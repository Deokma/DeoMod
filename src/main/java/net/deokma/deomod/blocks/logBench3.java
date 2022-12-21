package net.deokma.deomod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.deokma.deomod.sitOnStuff.SitEntity;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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

public class logBench3 extends HorizontalFacingBlock implements Waterloggable {

    /* FACING NORTH OR SOUTH */
    private static final VoxelShape TOP_NS = Block.createCuboidShape(0.0D, 6.0D,  3.0D, 16.0D, 8.0D, 13.0D);
    private static final VoxelShape MID_NS = Block.createCuboidShape(0.0D, 5.0D,  4.0D, 16.0D, 6.0D, 12.0D);
    private static final VoxelShape BOTTOM_NS = Block.createCuboidShape(0.0D, 4.0D,  5.0D, 16.0D, 5.0D, 11.0D);

    private static final VoxelShape FIRST_LEG_SUPPORT_1_NS = Block.createCuboidShape(2.0D, 3.0D,  6.0D, 4.0D, 4.0D, 10.0D);
    private static final VoxelShape FIRST_LEG_SUPPORT_2_NS = Block.createCuboidShape(2.0D, 2.0D,  5.0D, 4.0D, 3.0D, 11.0D);

    private static final VoxelShape FIRST_LEG_WEST_NS = Block.createCuboidShape(2.0D, 0.0D,  5.0D, 4.0D, 2.0D, 7.0D);
    private static final VoxelShape FIRST_LEG_EAST_NS = Block.createCuboidShape(2.0D, 0.0D,  9.0D, 4.0D, 2.0D, 11.0D);

    private static final VoxelShape SECOND_LEG_SUPPORT_1_NS = Block.createCuboidShape(12.0D, 3.0D,  6.0D, 14.0D, 4.0D, 10.0D);
    private static final VoxelShape SECOND_LEG_SUPPORT_2_NS = Block.createCuboidShape(12.0D, 2.0D,  5.0D, 14.0D, 3.0D, 11.0D);

    private static final VoxelShape SECOND_LEG_WEST_NS = Block.createCuboidShape(12.0D, 0.0D,  5.0D, 14.0D, 2.0D, 7.0D);
    private static final VoxelShape SECOND_LEG_EAST_NS = Block.createCuboidShape(12.0D, 0.0D,  9.0D, 14.0D, 2.0D, 11.0D);

    /* FACING WEST & EAST */
    private static final VoxelShape TOP_WE = Block.createCuboidShape(3.0D, 6.0D, 0.0D, 13.0D, 8.0D, 16.0D);
    private static final VoxelShape MID_WE = Block.createCuboidShape(4.0D, 5.0D,  0.0D, 12.0D, 6.0D, 16.0D);
    private static final VoxelShape BOTTOM_WE = Block.createCuboidShape(5.0D, 4.0D,  0.0D, 11.0D, 5.0D, 16.0D);

    private static final VoxelShape FIRST_LEG_SUPPORT_1_WE = Block.createCuboidShape(6.0D, 3.0D,  2.0D, 10.0D, 4.0D, 4.0D);
    private static final VoxelShape FIRST_LEG_SUPPORT_2_WE = Block.createCuboidShape(5.0D, 2.0D,  2.0D, 11.0D, 3.0D, 4.0D);

    private static final VoxelShape FIRST_LEG_WEST_WE = Block.createCuboidShape(5.0D, 0.0D,  2.0D, 7.0D, 2.0D, 4.0D);
    private static final VoxelShape FIRST_LEG_EAST_WE = Block.createCuboidShape(9.0D, 0.0D,  2.0D, 11.0D, 2.0D, 4.0D);

    private static final VoxelShape SECOND_LEG_SUPPORT_1_WE = Block.createCuboidShape(6.0D, 3.0D,  12.0D, 10.0D, 4.0D, 14.0D);
    private static final VoxelShape SECOND_LEG_SUPPORT_2_WE = Block.createCuboidShape(5.0D, 2.0D,  12.0D, 11.0D, 3.0D, 14.0D);

    private static final VoxelShape SECOND_LEG_WEST_WE = Block.createCuboidShape(5.0D, 0.0D,  12.0D, 7.0D, 2.0D, 14.0D);
    private static final VoxelShape SECOND_LEG_EAST_WE = Block.createCuboidShape(9.0D, 0.0D,  12.0D, 11.0D, 2.0D, 14.0D);

    private static final VoxelShape FACING_NS = VoxelShapes.union(TOP_NS, MID_NS, BOTTOM_NS, FIRST_LEG_SUPPORT_1_NS, FIRST_LEG_SUPPORT_2_NS, FIRST_LEG_WEST_NS, FIRST_LEG_EAST_NS, SECOND_LEG_SUPPORT_1_NS, SECOND_LEG_SUPPORT_2_NS, SECOND_LEG_WEST_NS, SECOND_LEG_EAST_NS);
    private static final VoxelShape FACING_WE = VoxelShapes.union(TOP_WE, MID_WE, BOTTOM_WE, FIRST_LEG_SUPPORT_1_WE, FIRST_LEG_SUPPORT_2_WE, FIRST_LEG_WEST_WE, FIRST_LEG_EAST_WE, SECOND_LEG_SUPPORT_1_WE, SECOND_LEG_SUPPORT_2_WE, SECOND_LEG_WEST_WE, SECOND_LEG_EAST_WE);

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public logBench3() {
        super(FabricBlockSettings.of(Material.WOOD)
                .resistance(3f)
                .hardness(2f)
                .sounds(BlockSoundGroup.WOOD));
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(Properties.WATERLOGGED);
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
            case SOUTH:
                return FACING_NS;
            case EAST:
            case WEST:
                return FACING_WE;
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
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
            sitMain();
            return ActionResult.SUCCESS;
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
}
