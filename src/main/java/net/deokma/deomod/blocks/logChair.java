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

public class logChair extends HorizontalFacingBlock implements Waterloggable {

    /* CHAIR LEGS */
    private static final VoxelShape FIRST_LEG = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 5.0D, 7.0D, 5.0D);
    private static final VoxelShape SECOND_LEG = Block.createCuboidShape(11.0D, 0.0D, 3.0D, 13.0D, 7.0D, 5.0D);
    private static final VoxelShape THIRD_LEG = Block.createCuboidShape(3.0D, 0.0D, 11.0D, 5.0D, 7.0D, 13.0D);
    private static final VoxelShape FOURTH_LEG = Block.createCuboidShape(11.0D, 0.0D, 11.0D, 13.0D, 7.0D, 13.0D);

    /* CHAIR SIT */
    private static final VoxelShape CHAIR_SIT = Block.createCuboidShape(2.0D, 7.0D, 2.0D, 14.0D, 9.0D, 14.0D);

    /* DIRECTIONS */
    private static final VoxelShape CHAIR_NORTH = Block.createCuboidShape(2.0D, 9.0D, 12.0D, 14.0D, 20.0D, 14.0D);
    private static final VoxelShape CHAIR_NORTH_SUPPORT_1 = Block.createCuboidShape(3.0D, 9.0D, 3.0D, 4.0D, 12.0D, 5.0D);
    private static final VoxelShape CHAIR_NORTH_SUPPORT_2 = Block.createCuboidShape(12.0D, 9.0D, 3.0D, 13.0D, 12.0D, 5.0D);
    private static final VoxelShape CHAIR_NORTH_SUPPORT_TOP_1 = Block.createCuboidShape(2.0D, 12.0D, 3.0D, 4.0D, 13.0D, 12.0D);
    private static final VoxelShape CHAIR_NORTH_SUPPORT_TOP_2 = Block.createCuboidShape(12.0D, 12.0D, 3.0D, 14.0D, 13.0D, 12.0D);

    private static final VoxelShape CHAIR_SOUTH = Block.createCuboidShape(2.0D, 9.0D, 2.0D, 14.0D, 20.0D, 4.0D);
    private static final VoxelShape CHAIR_SOUTH_SUPPORT_1 = Block.createCuboidShape(3.0D, 9.0D, 11.0D, 4.0D, 12.0D, 13.0D);
    private static final VoxelShape CHAIR_SOUTH_SUPPORT_2 = Block.createCuboidShape(12.0D, 9.0D, 11.0D, 13.0D, 12.0D, 13.0D);
    private static final VoxelShape CHAIR_SOUTH_SUPPORT_TOP_1 = Block.createCuboidShape(2.0D, 12.0D, 4.0D, 4.0D, 13.0D, 13.0D);
    private static final VoxelShape CHAIR_SOUTH_SUPPORT_TOP_2 = Block.createCuboidShape(12.0D, 12.0D, 4.0D, 14.0D, 13.0D, 13.0D);

    private static final VoxelShape CHAIR_EAST = Block.createCuboidShape(2.0D, 9.0D, 2.0D, 4.0D, 20.0D, 14.0D);
    private static final VoxelShape CHAIR_EAST_SUPPORT_1 = Block.createCuboidShape(11.0D, 9.0D, 3.0D, 13.0D, 12.0D, 4.0D);
    private static final VoxelShape CHAIR_EAST_SUPPORT_2 = Block.createCuboidShape(11.0D, 9.0D, 12.0D, 13.0D, 12.0D, 13.0D);
    private static final VoxelShape CHAIR_EAST_SUPPORT_TOP_1 = Block.createCuboidShape(4.0D, 12.0D, 2.0D, 13.0D, 13.0D, 4.0D);
    private static final VoxelShape CHAIR_EAST_SUPPORT_TOP_2 = Block.createCuboidShape(4.0D, 12.0D, 12.0D, 13.0D, 13.0D, 14.0D);

    private static final VoxelShape CHAIR_WEST = Block.createCuboidShape(12.0D, 9.0D, 2.0D, 14.0D, 20.0D, 14.0D);
    private static final VoxelShape CHAIR_WEST_SUPPORT_1 = Block.createCuboidShape(3.0D, 9.0D, 3.0D, 5.0D, 12.0D, 4.0D);
    private static final VoxelShape CHAIR_WEST_SUPPORT_2 = Block.createCuboidShape(3.0D, 9.0D, 12.0D, 5.0D, 12.0D, 13.0D);
    private static final VoxelShape CHAIR_WEST_SUPPORT_TOP_1 = Block.createCuboidShape(3.0D, 12.0D, 2.0D, 12.0D, 13.0D, 4.0D);
    private static final VoxelShape CHAIR_WEST_SUPPORT_TOP_2 = Block.createCuboidShape(3.0D, 12.0D, 12.0D, 12.0D, 13.0D, 14.0D);

    /* VOXEL GROUPS */
    private static final VoxelShape CHAIR_VOXELSHAPE = VoxelShapes.union(FIRST_LEG, SECOND_LEG, THIRD_LEG, FOURTH_LEG, CHAIR_SIT);

    private static final VoxelShape FACING_NORTH = VoxelShapes.union(CHAIR_VOXELSHAPE, CHAIR_NORTH);
    private static final VoxelShape FACING_SOUTH = VoxelShapes.union(CHAIR_VOXELSHAPE, CHAIR_SOUTH);
    private static final VoxelShape FACING_EAST = VoxelShapes.union(CHAIR_VOXELSHAPE, CHAIR_EAST);
    private static final VoxelShape FACING_WEST = VoxelShapes.union(CHAIR_VOXELSHAPE, CHAIR_WEST);

    private static final VoxelShape FACING_NORTH_ARMS =
            VoxelShapes.union(FACING_NORTH, CHAIR_NORTH_SUPPORT_1, CHAIR_NORTH_SUPPORT_2, CHAIR_NORTH_SUPPORT_TOP_1, CHAIR_NORTH_SUPPORT_TOP_2);
    private static final VoxelShape FACING_SOUTH_ARMS =
            VoxelShapes.union(FACING_SOUTH, CHAIR_SOUTH_SUPPORT_1, CHAIR_SOUTH_SUPPORT_2, CHAIR_SOUTH_SUPPORT_TOP_1, CHAIR_SOUTH_SUPPORT_TOP_2);
    private static final VoxelShape FACING_EAST_ARMS =
            VoxelShapes.union(FACING_EAST, CHAIR_EAST_SUPPORT_1, CHAIR_EAST_SUPPORT_2, CHAIR_EAST_SUPPORT_TOP_1, CHAIR_EAST_SUPPORT_TOP_2);
    private static final VoxelShape FACING_WEST_ARMS =
            VoxelShapes.union(FACING_WEST, CHAIR_WEST_SUPPORT_1, CHAIR_WEST_SUPPORT_2, CHAIR_WEST_SUPPORT_TOP_1, CHAIR_WEST_SUPPORT_TOP_2);

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private final boolean hasArmRests;
    private final String chairType;

    public logChair(boolean hasArmRestsBool) {
        super(FabricBlockSettings.of(Material.WOOD)
                .resistance(3f)
                .hardness(2f)
                .sounds(BlockSoundGroup.WOOD));
        setDefaultState(this.stateManager.getDefaultState()
                .with(WATERLOGGED, false));
        this.hasArmRests = hasArmRestsBool;
        chairType = null;
    }
    public logChair(boolean hasArmRestsBool, String chairType) {
        super(FabricBlockSettings.of(Material.WOOD)
                .resistance(3f)
                .hardness(2f)
                .sounds(BlockSoundGroup.WOOD));
        setDefaultState(this.stateManager.getDefaultState()
                .with(WATERLOGGED, false));
        this.hasArmRests = hasArmRestsBool;
        this.chairType = chairType;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);

        if (hasArmRests) {
            return switch (dir) {
                case NORTH -> FACING_NORTH_ARMS;
                case SOUTH -> FACING_SOUTH_ARMS;
                case EAST -> FACING_EAST_ARMS;
                case WEST -> FACING_WEST_ARMS;
                default -> VoxelShapes.fullCube();
            };
        } else {
            return switch (dir) {
                case NORTH -> FACING_NORTH;
                case SOUTH -> FACING_SOUTH;
                case EAST -> FACING_EAST;
                case WEST -> FACING_WEST;
                default -> VoxelShapes.fullCube();
            };
        }
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(Properties.WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
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

            world.setBlockState(pos, (BlockState) ((BlockState) state.with(WATERLOGGED, true)), Block.NOTIFY_ALL);
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

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();

        List<SitEntity> entities = world.getEntitiesByClass(SitEntity.class, new Box(x, y, z, x + 1, y + 1, z + 1), new Predicate<SitEntity>() {
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
        world.emitGameEvent((Entity) player, GameEvent.BLOCK_DESTROY, pos);

        OCCUPIED.remove(new Vec3d(x, y, z));
    }
}
