package net.deokma.deomod.blocks;

import net.deokma.deomod.registry.tagRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class logCoffeeTable extends FenceBlock {

    /* TABLE BASE */
    private static final VoxelShape TABLE_BASE = Block.createCuboidShape(0.0D, 12.0D,  0.0D, 16.0D, 16.0D, 16.0D);

    /* TABLE BASE */
    private static final VoxelShape LEG_NORTH_WEST = Block.createCuboidShape(1.0D, 0.0D,  1.0D, 4.0D, 14.0D, 4.0D); // NORTH_WEST
    private static final VoxelShape LEG_NORTH_EAST = Block.createCuboidShape(12.0D, 0.0D,  1.0D, 15.0D, 14.0D, 4.0D); // NORTH_EAST
    private static final VoxelShape LEG_SOUTH_WEST = Block.createCuboidShape(1.0D, 0.0D,  12.0D, 4.0D, 14.0D, 15.0D); // SOUTH_WEST
    private static final VoxelShape LEG_SOUTH_EAST = Block.createCuboidShape(12.0D, 0.0D,  12.0D, 15.0D, 14.0D, 15.0D); // SOUTH_EAST

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public logCoffeeTable() {
        super(FabricBlockSettings.of(Material.WOOD)
                .resistance(3f)
                .hardness(2f)
                .sounds(BlockSoundGroup.WOOD));
    }

    @Override
    public boolean canConnect(BlockState state, boolean neighborIsFullSquare, Direction dir) {
        Block block = state.getBlock();
        boolean canConnect = this.canConnectToTable(state);
        return !cannotConnect(state) && canConnect;
    }

    private boolean canConnectToTable(BlockState state) {
        return state.isIn(tagRegistry.Blocks.TABLES) == this.getDefaultState().isIn(tagRegistry.Blocks.TABLES);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return getFinalShape(state, world, pos, ctx);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        return getFinalShape(state, world, pos, ctx);
    }

    public VoxelShape getFinalShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {

        BlockState northBlock = world.getBlockState(pos.north());
        BlockState eastBlock = world.getBlockState(pos.east());
        BlockState southBlock = world.getBlockState(pos.south());
        BlockState westBlock = world.getBlockState(pos.west());

        Block actualBlock = state.getBlock();



        /* NOT CONNECTED AT ALL */
        if ( !northBlock.isIn(tagRegistry.Blocks.TABLES) &&
             !eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
             !southBlock.isIn(tagRegistry.Blocks.TABLES) &&
             !westBlock.isIn(tagRegistry.Blocks.TABLES))
        {
            return VoxelShapes.union(TABLE_BASE, LEG_NORTH_EAST, LEG_NORTH_WEST, LEG_SOUTH_EAST, LEG_SOUTH_WEST);
        }
        else
        {
            /***************************
            ** CONNECTED BY TWO BLOCK **
            ***************************/

            /* CONNECTED ON NORTH AND EAST */
            if (  northBlock.isIn(tagRegistry.Blocks.TABLES) &&
                  eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
                 !southBlock.isIn(tagRegistry.Blocks.TABLES) &&
                 !westBlock.isIn(tagRegistry.Blocks.TABLES))
            {
                //return VoxelShapes.union(TABLE_BASE, LEG_SOUTH_WEST);
                return Stream.of(
                        Block.createCuboidShape(-13, 0, 2, -11, 14, 4),
                        Block.createCuboidShape(-13, 0, 12, -11, 14, 14),
                        Block.createCuboidShape(11, 0, 2, 13, 14, 4),
                        Block.createCuboidShape(11, 0, 12, 13, 14, 14),
                        Block.createCuboidShape(-13, 0, 2, -11, 14, 4),
                        Block.createCuboidShape(-13, 0, 12, -11, 14, 14),
                        Block.createCuboidShape(-16, 14, 0, 16, 16, 16),
                        Block.createCuboidShape(-15, 6, 1, 15, 7, 15),
                        Block.createCuboidShape(8.2, 16.2, 16.2, -8.2, 8.8, -0.2)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }

            /* CONNECTED ON NORTH AND WEST */
            else if (  northBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !southBlock.isIn(tagRegistry.Blocks.TABLES) &&
                       westBlock.isIn(tagRegistry.Blocks.TABLES))
            {
                //return VoxelShapes.union(TABLE_BASE, LEG_SOUTH_EAST);
              return   Stream.of(
                        Block.createCuboidShape(-13, 0, 2, -11, 14, 4),
                        Block.createCuboidShape(-13, 0, 12, -11, 14, 14),
                        Block.createCuboidShape(11, 0, 2, 13, 14, 4),
                        Block.createCuboidShape(11, 0, 12, 13, 14, 14),
                        Block.createCuboidShape(-13, 0, 2, -11, 14, 4),
                        Block.createCuboidShape(-13, 0, 12, -11, 14, 14),
                        Block.createCuboidShape(-16, 14, 0, 16, 16, 16),
                        Block.createCuboidShape(-15, 6, 1, 15, 7, 15),
                        Block.createCuboidShape(8.2, 16.2, 16.2, -8.2, 8.8, -0.2)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }

            /* CONNECTED ON SOUTH AND EAST */
            else if ( !northBlock.isIn(tagRegistry.Blocks.TABLES) &&
                       eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
                       southBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !westBlock.isIn(tagRegistry.Blocks.TABLES))
            {
                //return VoxelShapes.union(TABLE_BASE, LEG_NORTH_WEST);
              return   Stream.of(
                        Block.createCuboidShape(-13, 0, 2, -11, 14, 4),
                        Block.createCuboidShape(-13, 0, 12, -11, 14, 14),
                        Block.createCuboidShape(11, 0, 2, 13, 14, 4),
                        Block.createCuboidShape(11, 0, 12, 13, 14, 14),
                        Block.createCuboidShape(-13, 0, 2, -11, 14, 4),
                        Block.createCuboidShape(-13, 0, 12, -11, 14, 14),
                        Block.createCuboidShape(-16, 14, 0, 16, 16, 16),
                        Block.createCuboidShape(-15, 6, 1, 15, 7, 15),
                        Block.createCuboidShape(8.2, 16.2, 16.2, -8.2, 8.8, -0.2)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }

            /* CONNECTED ON SOUTH AND WEST */
            else if ( !northBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      southBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      westBlock.isIn(tagRegistry.Blocks.TABLES))
            {
                //return VoxelShapes.union(TABLE_BASE, LEG_NORTH_EAST);
             return    Stream.of(
                        Block.createCuboidShape(-13, 0, 2, -11, 14, 4),
                        Block.createCuboidShape(-13, 0, 12, -11, 14, 14),
                        Block.createCuboidShape(11, 0, 2, 13, 14, 4),
                        Block.createCuboidShape(11, 0, 12, 13, 14, 14),
                        Block.createCuboidShape(-13, 0, 2, -11, 14, 4),
                        Block.createCuboidShape(-13, 0, 12, -11, 14, 14),
                        Block.createCuboidShape(-16, 14, 0, 16, 16, 16),
                        Block.createCuboidShape(-15, 6, 1, 15, 7, 15),
                        Block.createCuboidShape(8.2, 16.2, 16.2, -8.2, 8.8, -0.2)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }

            /********************************
            ** CONNECTED BY ONLY ONE BLOCK **
            ********************************/

            /* CONNECTED ON NORTH ONLY */
            else if (  northBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !southBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !westBlock.isIn(tagRegistry.Blocks.TABLES))
            {
                return VoxelShapes.union(TABLE_BASE, LEG_SOUTH_EAST, LEG_SOUTH_WEST);
            }

            /* CONNECTED ON EAST ONLY */
            else if ( !northBlock.isIn(tagRegistry.Blocks.TABLES) &&
                       eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !southBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !westBlock.isIn(tagRegistry.Blocks.TABLES))
            {
                return VoxelShapes.union(TABLE_BASE, LEG_NORTH_WEST, LEG_SOUTH_WEST);
            }

            /* CONNECTED ON SOUTH */
            else if ( !northBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
                       southBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !westBlock.isIn(tagRegistry.Blocks.TABLES))
            {
                return VoxelShapes.union(TABLE_BASE, LEG_NORTH_EAST, LEG_NORTH_WEST);
            }

            /* CONNECTED ON WEST */
            else if ( !northBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !eastBlock.isIn(tagRegistry.Blocks.TABLES) &&
                      !southBlock.isIn(tagRegistry.Blocks.TABLES) &&
                       westBlock.isIn(tagRegistry.Blocks.TABLES))
            {
                return VoxelShapes.union(TABLE_BASE, LEG_NORTH_EAST, LEG_SOUTH_EAST);
            }

            /* CONNECTED ON ALL DIRECTIONS */
            else return VoxelShapes.union(TABLE_BASE);
        }
    }
}