package net.deokma.deomod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.deokma.deomod.blocks.block_entities.logBench_BlockEntity;
import net.deokma.deomod.sitOnStuff.SitEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.function.Predicate;

import static net.deokma.deomod.sitOnStuff.Sit.sitMain;
import static net.deokma.deomod.sitOnStuff.SitEntity.OCCUPIED;

public class logBench extends HorizontalFacingBlock implements BlockEntityProvider, Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final IntProperty AXE_TYPE = IntProperty.of("axe_type", 0,6);

    public logBench() {
        super(FabricBlockSettings.of(Material.WOOD)
                .resistance(3f)
                .hardness(2f)
                .sounds(BlockSoundGroup.WOOD));
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false)
                .with(AXE_TYPE, 0));

    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
            case SOUTH:
                return VoxelShapes.cuboid(0, 0, 0.3125, 1, 0.3750, 0.6875);
            case EAST:
            case WEST:
                return VoxelShapes.cuboid(0.3125, 0, 0, 0.6875, 0.3750, 1);
            default:
                return VoxelShapes.fullCube();
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(Properties.WATERLOGGED);
        stateManager.add(AXE_TYPE);

    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new logBench_BlockEntity(pos, state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof logBench_BlockEntity) {
                ItemScatterer.spawn(world, pos, (logBench_BlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.get(Properties.WATERLOGGED) && fluidState.getFluid() == Fluids.WATER) {

            world.setBlockState(pos, (BlockState)((BlockState)state.with(WATERLOGGED, true)), Block.NOTIFY_ALL);
            world.createAndScheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
            return true;
        }
        return false;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        Inventory blockEntity = (Inventory) world.getBlockEntity(pos);

        if(player.getStackInHand(hand).isEmpty() && world.getBlockState(pos).get(AXE_TYPE).equals(0))
        {
            world.getBlockState(pos).get(AXE_TYPE);
            world.setBlockState(pos, state.with(AXE_TYPE, 0));
            blockEntity.removeStack(0);
            sitMain();
            return ActionResult.SUCCESS;
        }
        else if (!player.getStackInHand(hand).isEmpty() && world.getBlockState(pos).get(AXE_TYPE).equals(0))
        {
            if (player.isHolding(Items.NETHERITE_AXE))
            {
                storeAxe(state, world, pos, player, hand, 6);
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            }
            else if (player.isHolding(Items.DIAMOND_AXE))
            {
                storeAxe(state, world, pos, player, hand, 5);
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            }
            else if (player.isHolding(Items.GOLDEN_AXE)) {
                storeAxe(state, world, pos, player, hand, 4);
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            }
            else if (player.isHolding(Items.IRON_AXE)) {
                storeAxe(state, world, pos, player, hand, 3);
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            }
            else if (player.isHolding(Items.STONE_AXE)) {
                storeAxe(state, world, pos, player, hand, 2);
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            }
            else if (player.isHolding(Items.WOODEN_AXE)) {
                storeAxe(state, world, pos, player, hand, 1);
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            }
            return ActionResult.SUCCESS;
        }
        else if (player.getStackInHand(hand).isEmpty() && !world.getBlockState(pos).get(AXE_TYPE).equals(0))
        {
            world.getBlockState(pos).get(AXE_TYPE);
            world.setBlockState(pos, state.with(AXE_TYPE, 0).with(Properties.HORIZONTAL_FACING, world.getBlockState(pos).get(Properties.HORIZONTAL_FACING).getOpposite()));
            player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1, 1);

            if (!blockEntity.getStack(0).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
            }

            return ActionResult.SUCCESS;
        }
        else
        {
            return ActionResult.PASS;
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();

        List<SitEntity> entities = world.getEntitiesByClass(SitEntity.class, new Box(x, y, z, x+1, y+1, z+1), new Predicate<SitEntity>() {
            @Override
            public boolean test(SitEntity entity) {
                return entity.hasPassengers();
            }
        });
        for (SitEntity entity : entities) {
            entity.remove(Entity.RemovalReason.DISCARDED);
        }

        // BREAK SOUND AND PARTICLES
        this.spawnBreakParticles(world, player, pos, state);
        world.emitGameEvent((Entity)player, GameEvent.BLOCK_DESTROY, pos);

        OCCUPIED.remove(new Vec3d(x, y, z));
    }

    private <StateName> void storeAxe(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, StateName stateName) {

        final int stateStatus = (int) stateName;

        switch(world.getBlockState(pos).get(Properties.HORIZONTAL_FACING).toString()) {
            case "north":
            case "south":
                if(player.getHorizontalFacing().equals(Direction.NORTH) || player.getHorizontalFacing().equals(Direction.SOUTH))
                {
                    player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1, 1);
                    world.setBlockState(pos, state.with(AXE_TYPE, stateStatus).with(Properties.HORIZONTAL_FACING, player.getHorizontalFacing()));
                }
                else if(player.getHorizontalFacing().equals(Direction.EAST) || player.getHorizontalFacing().equals(Direction.WEST))
                {
                    player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1, 1);
                    world.setBlockState(pos, state.with(AXE_TYPE, stateStatus).with(Properties.HORIZONTAL_FACING, Direction.NORTH));
                }
                break;
            case "east":
            case "west":
                if(player.getHorizontalFacing().equals(Direction.EAST) || player.getHorizontalFacing().equals(Direction.WEST))
                {
                    player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1, 1);
                    world.setBlockState(pos, state.with(AXE_TYPE, stateStatus).with(Properties.HORIZONTAL_FACING, player.getHorizontalFacing()));
                }
                else if(player.getHorizontalFacing().equals(Direction.NORTH) || player.getHorizontalFacing().equals(Direction.SOUTH))
                {
                    player.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1, 1);
                    world.setBlockState(pos, state.with(AXE_TYPE, stateStatus).with(Properties.HORIZONTAL_FACING, Direction.EAST));
                }
                break;
        }
    }
}
