package net.deokma.deomod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.deokma.deomod.blocks.block_entities.logSmallStool_BlockEntity;
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

import static net.deokma.deomod.sitOnStuff.SitEntity.OCCUPIED;

public class logSmallStool extends HorizontalFacingBlock implements BlockEntityProvider, Waterloggable {

    private static final VoxelShape SIT = Block.createCuboidShape(3.0D, 6.0D,  3.0D, 13.0D, 9.0D, 13.0D);
    private static final VoxelShape FIRST_LEG = Block.createCuboidShape(4.0D, 0.0D,  4.0D, 6.0D, 6.0D, 6.0D);
    private static final VoxelShape SECOND_LEG = Block.createCuboidShape(4.0D, 0.0D,  10.0D, 6.0D, 6.0D, 12.0D);
    private static final VoxelShape THIRD_LEG = Block.createCuboidShape(10.0D, 0.0D,  4.0D, 12.0D, 6.0D, 6.0D);
    private static final VoxelShape FOURTH_LEG = Block.createCuboidShape(10.0D, 0.0D,  10.0D, 12.0D, 6.0D, 12.0D);

    private static final VoxelShape STOOL_VOXELSHAPE = VoxelShapes.union(SIT, FIRST_LEG, SECOND_LEG, THIRD_LEG, FOURTH_LEG);

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final IntProperty WOOL_COLOR = IntProperty.of("wool_color", 0,16);

    public logSmallStool() {
        super(FabricBlockSettings.of(Material.WOOD)
                .resistance(3f)
                .hardness(2f)
                .sounds(BlockSoundGroup.WOOD));
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false)
                .with(WOOL_COLOR, 0));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        return STOOL_VOXELSHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(Properties.WATERLOGGED);
        stateManager.add(WOOL_COLOR);

    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new logSmallStool_BlockEntity(pos, state);
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
            if (blockEntity instanceof logSmallStool_BlockEntity) {
                ItemScatterer.spawn(world, pos, (logSmallStool_BlockEntity)blockEntity);
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

        if(player.getStackInHand(hand).isEmpty() && !player.isSneaking())
        {
            return ActionResult.SUCCESS;
        }
        else if (!player.getStackInHand(hand).isEmpty() && world.getBlockState(pos).get(WOOL_COLOR).equals(0))
        {
            if (player.isHolding(Items.WHITE_CARPET))
            {
                placeCarpet(state, world, pos, player, hand, 1);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.ORANGE_CARPET))
            {
                placeCarpet(state, world, pos, player, hand, 2);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.MAGENTA_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 3);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.LIGHT_BLUE_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 4);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.YELLOW_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 5);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.LIME_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 6);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.PINK_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 7);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.GRAY_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 8);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.LIGHT_GRAY_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 9);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.CYAN_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 10);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.PURPLE_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 11);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.BLUE_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 12);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.BROWN_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 13);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.GREEN_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 14);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.RED_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 15);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            else if (player.isHolding(Items.BLACK_CARPET)) {
                placeCarpet(state, world, pos, player, hand, 16);
                placeCarpetOnBlockEntity(blockEntity, player, hand);
                removeCarpetFromPlayer(player, hand);
            }
            return ActionResult.SUCCESS;

        }
        else if (player.getStackInHand(hand).isEmpty() && !world.getBlockState(pos).get(WOOL_COLOR).equals(0) && player.isSneaking())
        {
            placeCarpet(state, world, pos, player, hand, 0);
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

    private <StateName> void placeCarpet(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, StateName stateName) {
        final int stateStatus = (int) stateName;
        player.playSound(SoundEvents.BLOCK_WOOL_PLACE, 1, 1);
        world.setBlockState(pos, state.with(WOOL_COLOR, stateStatus).with(Properties.HORIZONTAL_FACING, world.getBlockState(pos).get(Properties.HORIZONTAL_FACING)));
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

    private void removeCarpetFromPlayer(PlayerEntity player, Hand hand)
    {
        int playerStackNumber = player.getStackInHand(hand).getCount();
        if(playerStackNumber > 1)
        {
            player.getStackInHand(hand).setCount(--playerStackNumber);
        }
        else if (playerStackNumber == 1)
        {
            player.getStackInHand(hand).setCount(0);
        }
    }
    private void placeCarpetOnBlockEntity(Inventory blockEntity, PlayerEntity player, Hand hand)
    {
        blockEntity.setStack(0, player.getStackInHand(hand).copy());
        blockEntity.getStack(0).setCount(1);
    }
}
