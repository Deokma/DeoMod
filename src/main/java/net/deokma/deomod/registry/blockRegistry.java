package net.deokma.deomod.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.deokma.deomod.blocks.*;
import net.deokma.deomod.blocks.block_entities.logBench_BlockEntity;
import net.deokma.deomod.blocks.block_entities.logSmallStool_BlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class blockRegistry {

    public static final String MOD_ID = "deomod";

    /////////////
    // BENCHES //
    /////////////
    public static final Block OAK_LOG_BENCH = new logBench();
    public static final Block BIRCH_LOG_BENCH = new logBench();
    public static final Block SPRUCE_LOG_BENCH = new logBench();
    public static final Block DARK_OAK_LOG_BENCH = new logBench();
    public static final Block ACACIA_LOG_BENCH = new logBench();
    public static final Block JUNGLE_LOG_BENCH = new logBench();
    public static final Block CRIMSON_STEM_BENCH = new logBench();
    public static final Block WARPED_STEM_BENCH = new logBench();

    public static final Block OAK_LOG_BENCH_2 = new logBench2();
    public static final Block BIRCH_LOG_BENCH_2 = new logBench2();
    public static final Block SPRUCE_LOG_BENCH_2 = new logBench2();
    public static final Block DARK_OAK_LOG_BENCH_2 = new logBench2();
    public static final Block ACACIA_LOG_BENCH_2 = new logBench2();
    public static final Block JUNGLE_LOG_BENCH_2 = new logBench2();
    public static final Block CRIMSON_STEM_BENCH_2 = new logBench2();
    public static final Block WARPED_STEM_BENCH_2 = new logBench2();

    public static final Block OAK_LOG_BENCH_3 = new logBench3();
    public static final Block BIRCH_LOG_BENCH_3 = new logBench3();
    public static final Block SPRUCE_LOG_BENCH_3 = new logBench3();
    public static final Block DARK_OAK_LOG_BENCH_3 = new logBench3();
    public static final Block ACACIA_LOG_BENCH_3 = new logBench3();
    public static final Block JUNGLE_LOG_BENCH_3 = new logBench3();
    public static final Block CRIMSON_STEM_BENCH_3 = new logBench3();
    public static final Block WARPED_STEM_BENCH_3 = new logBench3();

    ////////////
    // STOOLS //
    ////////////
    public static final Block OAK_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block BIRCH_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block SPRUCE_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block DARK_OAK_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block ACACIA_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block JUNGLE_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block CRIMSON_STEM_SMALL_STOOL = new logSmallStool();
    public static final Block WARPED_STEM_SMALL_STOOL = new logSmallStool();

    public static final Block STRIPPED_OAK_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block STRIPPED_BIRCH_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block STRIPPED_SPRUCE_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block STRIPPED_DARK_OAK_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block STRIPPED_ACACIA_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block STRIPPED_JUNGLE_LOG_SMALL_STOOL = new logSmallStool();
    public static final Block STRIPPED_CRIMSON_STEM_SMALL_STOOL = new logSmallStool();
    public static final Block STRIPPED_WARPED_STEM_SMALL_STOOL = new logSmallStool();

    ////////////
    // CHAIRS //
    ////////////
    public static final Block OAK_LOG_CHAIR = new logChair(false);
    public static final Block BIRCH_LOG_CHAIR = new logChair(false);
    public static final Block SPRUCE_LOG_CHAIR = new logChair(false);
    public static final Block DARK_OAK_LOG_CHAIR = new logChair(false);
    public static final Block ACACIA_LOG_CHAIR = new logChair(false);
    public static final Block JUNGLE_LOG_CHAIR = new logChair(false);
    public static final Block CRIMSON_STEM_CHAIR = new logChair(false);
    public static final Block WARPED_STEM_CHAIR = new logChair(false);

    public static final Block OAK_LOG_CHAIR_2 = new logChair(true);
    public static final Block BIRCH_LOG_CHAIR_2 = new logChair(true);
    public static final Block SPRUCE_LOG_CHAIR_2 = new logChair(true);
    public static final Block DARK_OAK_LOG_CHAIR_2 = new logChair(true);
    public static final Block ACACIA_LOG_CHAIR_2 = new logChair(true);
    public static final Block JUNGLE_LOG_CHAIR_2 = new logChair(true);
    public static final Block CRIMSON_STEM_CHAIR_2 = new logChair(true);
    public static final Block WARPED_STEM_CHAIR_2 = new logChair(true);

    public static final Block STRIPPED_OAK_LOG_CHAIR = new logChair(false);
    public static final Block STRIPPED_BIRCH_LOG_CHAIR = new logChair(false);
    public static final Block STRIPPED_SPRUCE_LOG_CHAIR = new logChair(false);
    public static final Block STRIPPED_DARK_OAK_LOG_CHAIR = new logChair(false);
    public static final Block STRIPPED_ACACIA_LOG_CHAIR = new logChair(false);
    public static final Block STRIPPED_JUNGLE_LOG_CHAIR = new logChair(false);
    public static final Block STRIPPED_CRIMSON_STEM_CHAIR = new logChair(false);
    public static final Block STRIPPED_WARPED_STEM_CHAIR = new logChair(false);

    public static final Block STRIPPED_OAK_LOG_CHAIR_2 = new logChair(true);
    public static final Block STRIPPED_BIRCH_LOG_CHAIR_2 = new logChair(true);
    public static final Block STRIPPED_SPRUCE_LOG_CHAIR_2 = new logChair(true);
    public static final Block STRIPPED_DARK_OAK_LOG_CHAIR_2 = new logChair(true);
    public static final Block STRIPPED_ACACIA_LOG_CHAIR_2 = new logChair(true);
    public static final Block STRIPPED_JUNGLE_LOG_CHAIR_2 = new logChair(true);
    public static final Block STRIPPED_CRIMSON_STEM_CHAIR_2 = new logChair(true);
    public static final Block STRIPPED_WARPED_STEM_CHAIR_2 = new logChair(true);

    ////////////
    // TABLES //
    ////////////
    public static final Block OAK_LOG_TABLE = new logTable();
    public static final Block BIRCH_LOG_TABLE = new logTable();
    public static final Block SPRUCE_LOG_TABLE = new logTable();
    public static final Block DARK_OAK_LOG_TABLE = new logTable();
    public static final Block ACACIA_LOG_TABLE = new logTable();
    public static final Block JUNGLE_LOG_TABLE = new logTable();
    public static final Block CRIMSON_STEM_TABLE = new logTable();
    public static final Block WARPED_STEM_TABLE = new logTable();

    public static final Block STRIPPED_OAK_LOG_TABLE = new logTable();
    public static final Block STRIPPED_BIRCH_LOG_TABLE = new logTable();
    public static final Block STRIPPED_SPRUCE_LOG_TABLE = new logTable();
    public static final Block STRIPPED_DARK_OAK_LOG_TABLE = new logTable();
    public static final Block STRIPPED_ACACIA_LOG_TABLE = new logTable();
    public static final Block STRIPPED_JUNGLE_LOG_TABLE = new logTable();
    public static final Block STRIPPED_CRIMSON_STEM_TABLE = new logTable();
    public static final Block STRIPPED_WARPED_STEM_TABLE = new logTable();

    public static BlockEntityType<logBench_BlockEntity> LOG_BENCH_BLOCK_ENTITY;
    public static BlockEntityType<logSmallStool_BlockEntity> LOG_SMALL_STOOL_BLOCK_ENTITY;

    public static final ItemGroup seatsItemGroup = FabricItemGroupBuilder.build(new Identifier("deomod", "seats"), () -> new ItemStack(STRIPPED_OAK_LOG_CHAIR));
    public static final ItemGroup tablesItemGroup = FabricItemGroupBuilder.build(new Identifier("deomod", "tables"), () -> new ItemStack(OAK_LOG_TABLE));

    public static final Block WORKBENCH = new workBench();

    public static void registerWorkBench() {
        /* WORKBENCH */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "workbench"), WORKBENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "workbench"), new BlockItem(WORKBENCH, new Item.Settings().group(ItemGroup.DECORATIONS)));

    }
    public static void registerBlockEntities() {
        LOG_BENCH_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "log_bench"),
                FabricBlockEntityTypeBuilder.create(logBench_BlockEntity::new,
                        OAK_LOG_BENCH, BIRCH_LOG_BENCH, SPRUCE_LOG_BENCH, DARK_OAK_LOG_BENCH, ACACIA_LOG_BENCH, JUNGLE_LOG_BENCH, CRIMSON_STEM_BENCH, WARPED_STEM_BENCH,
                        OAK_LOG_BENCH_2, BIRCH_LOG_BENCH_2, SPRUCE_LOG_BENCH_2, DARK_OAK_LOG_BENCH_2, ACACIA_LOG_BENCH_2, JUNGLE_LOG_BENCH_2, CRIMSON_STEM_BENCH_2, WARPED_STEM_BENCH_2
                ).build(null));

        LOG_SMALL_STOOL_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "log_small_stool"),
                FabricBlockEntityTypeBuilder.create(logSmallStool_BlockEntity::new,
                        OAK_LOG_SMALL_STOOL, BIRCH_LOG_SMALL_STOOL, SPRUCE_LOG_SMALL_STOOL, DARK_OAK_LOG_SMALL_STOOL,
                        ACACIA_LOG_SMALL_STOOL, JUNGLE_LOG_SMALL_STOOL, CRIMSON_STEM_SMALL_STOOL, WARPED_STEM_SMALL_STOOL,
                        STRIPPED_OAK_LOG_SMALL_STOOL, STRIPPED_BIRCH_LOG_SMALL_STOOL, STRIPPED_SPRUCE_LOG_SMALL_STOOL, STRIPPED_DARK_OAK_LOG_SMALL_STOOL,
                        STRIPPED_ACACIA_LOG_SMALL_STOOL, STRIPPED_JUNGLE_LOG_SMALL_STOOL, STRIPPED_CRIMSON_STEM_SMALL_STOOL, STRIPPED_WARPED_STEM_SMALL_STOOL
                ).build(null));
    }

    public static void registerBenches() {

        /* LOG BENCHES 1 */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oak_log_bench"), OAK_LOG_BENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oak_log_bench"), new BlockItem(OAK_LOG_BENCH, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "birch_log_bench"), BIRCH_LOG_BENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "birch_log_bench"), new BlockItem(BIRCH_LOG_BENCH, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "spruce_log_bench"), SPRUCE_LOG_BENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "spruce_log_bench"), new BlockItem(SPRUCE_LOG_BENCH, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dark_oak_log_bench"), DARK_OAK_LOG_BENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dark_oak_log_bench"), new BlockItem(DARK_OAK_LOG_BENCH, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "acacia_log_bench"), ACACIA_LOG_BENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "acacia_log_bench"), new BlockItem(ACACIA_LOG_BENCH, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "jungle_log_bench"), JUNGLE_LOG_BENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "jungle_log_bench"), new BlockItem(JUNGLE_LOG_BENCH, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "crimson_stem_bench"), CRIMSON_STEM_BENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crimson_stem_bench"), new BlockItem(CRIMSON_STEM_BENCH, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "warped_stem_bench"), WARPED_STEM_BENCH);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "warped_stem_bench"), new BlockItem(WARPED_STEM_BENCH, new Item.Settings().group(seatsItemGroup)));

        /* LOG BENCHES 2 */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oak_log_bench_2"), OAK_LOG_BENCH_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oak_log_bench_2"), new BlockItem(OAK_LOG_BENCH_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "birch_log_bench_2"), BIRCH_LOG_BENCH_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "birch_log_bench_2"), new BlockItem(BIRCH_LOG_BENCH_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "spruce_log_bench_2"), SPRUCE_LOG_BENCH_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "spruce_log_bench_2"), new BlockItem(SPRUCE_LOG_BENCH_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dark_oak_log_bench_2"), DARK_OAK_LOG_BENCH_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dark_oak_log_bench_2"), new BlockItem(DARK_OAK_LOG_BENCH_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "acacia_log_bench_2"), ACACIA_LOG_BENCH_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "acacia_log_bench_2"), new BlockItem(ACACIA_LOG_BENCH_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "jungle_log_bench_2"), JUNGLE_LOG_BENCH_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "jungle_log_bench_2"), new BlockItem(JUNGLE_LOG_BENCH_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "crimson_stem_bench_2"), CRIMSON_STEM_BENCH_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crimson_stem_bench_2"), new BlockItem(CRIMSON_STEM_BENCH_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "warped_stem_bench_2"), WARPED_STEM_BENCH_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "warped_stem_bench_2"), new BlockItem(WARPED_STEM_BENCH_2, new Item.Settings().group(seatsItemGroup)));

        /* LOG BENCHES 3 */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oak_log_bench_3"), OAK_LOG_BENCH_3);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oak_log_bench_3"), new BlockItem(OAK_LOG_BENCH_3, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "birch_log_bench_3"), BIRCH_LOG_BENCH_3);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "birch_log_bench_3"), new BlockItem(BIRCH_LOG_BENCH_3, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "spruce_log_bench_3"), SPRUCE_LOG_BENCH_3);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "spruce_log_bench_3"), new BlockItem(SPRUCE_LOG_BENCH_3, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dark_oak_log_bench_3"), DARK_OAK_LOG_BENCH_3);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dark_oak_log_bench_3"), new BlockItem(DARK_OAK_LOG_BENCH_3, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "acacia_log_bench_3"), ACACIA_LOG_BENCH_3);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "acacia_log_bench_3"), new BlockItem(ACACIA_LOG_BENCH_3, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "jungle_log_bench_3"), JUNGLE_LOG_BENCH_3);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "jungle_log_bench_3"), new BlockItem(JUNGLE_LOG_BENCH_3, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "crimson_stem_bench_3"), CRIMSON_STEM_BENCH_3);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crimson_stem_bench_3"), new BlockItem(CRIMSON_STEM_BENCH_3, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "warped_stem_bench_3"), WARPED_STEM_BENCH_3);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "warped_stem_bench_3"), new BlockItem(WARPED_STEM_BENCH_3, new Item.Settings().group(seatsItemGroup)));
    }
    public static void registerStools() {

        /* LOG SMALL STOOL */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oak_log_small_stool"), OAK_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oak_log_small_stool"), new BlockItem(OAK_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "birch_log_small_stool"), BIRCH_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "birch_log_small_stool"), new BlockItem(BIRCH_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "spruce_log_small_stool"), SPRUCE_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "spruce_log_small_stool"), new BlockItem(SPRUCE_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dark_oak_log_small_stool"), DARK_OAK_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dark_oak_log_small_stool"), new BlockItem(DARK_OAK_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "acacia_log_small_stool"), ACACIA_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "acacia_log_small_stool"), new BlockItem(ACACIA_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "jungle_log_small_stool"), JUNGLE_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "jungle_log_small_stool"), new BlockItem(JUNGLE_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "crimson_stem_small_stool"), CRIMSON_STEM_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crimson_stem_small_stool"), new BlockItem(CRIMSON_STEM_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "warped_stem_small_stool"), WARPED_STEM_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "warped_stem_small_stool"), new BlockItem(WARPED_STEM_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        /* STRIPPED LOG SMALL STOOL */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_oak_log_small_stool"), STRIPPED_OAK_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_oak_log_small_stool"), new BlockItem(STRIPPED_OAK_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_birch_log_small_stool"), STRIPPED_BIRCH_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_birch_log_small_stool"), new BlockItem(STRIPPED_BIRCH_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_spruce_log_small_stool"), STRIPPED_SPRUCE_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_spruce_log_small_stool"), new BlockItem(STRIPPED_SPRUCE_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_dark_oak_log_small_stool"), STRIPPED_DARK_OAK_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_dark_oak_log_small_stool"), new BlockItem(STRIPPED_DARK_OAK_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_acacia_log_small_stool"), STRIPPED_ACACIA_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_acacia_log_small_stool"), new BlockItem(STRIPPED_ACACIA_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_jungle_log_small_stool"), STRIPPED_JUNGLE_LOG_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_jungle_log_small_stool"), new BlockItem(STRIPPED_JUNGLE_LOG_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_crimson_stem_small_stool"), STRIPPED_CRIMSON_STEM_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_crimson_stem_small_stool"), new BlockItem(STRIPPED_CRIMSON_STEM_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_warped_stem_small_stool"), STRIPPED_WARPED_STEM_SMALL_STOOL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_warped_stem_small_stool"), new BlockItem(STRIPPED_WARPED_STEM_SMALL_STOOL, new Item.Settings().group(seatsItemGroup)));
    }
    public static void registerChairs() {

        /* SIMPLE LOG CHAIRS */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oak_log_chair"), OAK_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oak_log_chair"), new BlockItem(OAK_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "birch_log_chair"), BIRCH_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "birch_log_chair"), new BlockItem(BIRCH_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "spruce_log_chair"), SPRUCE_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "spruce_log_chair"), new BlockItem(SPRUCE_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dark_oak_log_chair"), DARK_OAK_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dark_oak_log_chair"), new BlockItem(DARK_OAK_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "acacia_log_chair"), ACACIA_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "acacia_log_chair"), new BlockItem(ACACIA_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "jungle_log_chair"), JUNGLE_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "jungle_log_chair"), new BlockItem(JUNGLE_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "crimson_stem_chair"), CRIMSON_STEM_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crimson_stem_chair"), new BlockItem(CRIMSON_STEM_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "warped_stem_chair"), WARPED_STEM_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "warped_stem_chair"), new BlockItem(WARPED_STEM_CHAIR, new Item.Settings().group(seatsItemGroup)));

        /* SIMPLE LOG CHAIRS 2 */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oak_log_chair_2"), OAK_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oak_log_chair_2"), new BlockItem(OAK_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "birch_log_chair_2"), BIRCH_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "birch_log_chair_2"), new BlockItem(BIRCH_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "spruce_log_chair_2"), SPRUCE_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "spruce_log_chair_2"), new BlockItem(SPRUCE_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dark_oak_log_chair_2"), DARK_OAK_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dark_oak_log_chair_2"), new BlockItem(DARK_OAK_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "acacia_log_chair_2"), ACACIA_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "acacia_log_chair_2"), new BlockItem(ACACIA_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "jungle_log_chair_2"), JUNGLE_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "jungle_log_chair_2"), new BlockItem(JUNGLE_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "crimson_stem_chair_2"), CRIMSON_STEM_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crimson_stem_chair_2"), new BlockItem(CRIMSON_STEM_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "warped_stem_chair_2"), WARPED_STEM_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "warped_stem_chair_2"), new BlockItem(WARPED_STEM_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        /* SIMPLE STRIPPED LOG CHAIRS */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_oak_log_chair"), STRIPPED_OAK_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_oak_log_chair"), new BlockItem(STRIPPED_OAK_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_birch_log_chair"), STRIPPED_BIRCH_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_birch_log_chair"), new BlockItem(STRIPPED_BIRCH_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_spruce_log_chair"), STRIPPED_SPRUCE_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_spruce_log_chair"), new BlockItem(STRIPPED_SPRUCE_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_dark_oak_log_chair"), STRIPPED_DARK_OAK_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_dark_oak_log_chair"), new BlockItem(STRIPPED_DARK_OAK_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_acacia_log_chair"), STRIPPED_ACACIA_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_acacia_log_chair"), new BlockItem(STRIPPED_ACACIA_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_jungle_log_chair"), STRIPPED_JUNGLE_LOG_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_jungle_log_chair"), new BlockItem(STRIPPED_JUNGLE_LOG_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_crimson_stem_chair"), STRIPPED_CRIMSON_STEM_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_crimson_stem_chair"), new BlockItem(STRIPPED_CRIMSON_STEM_CHAIR, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_warped_stem_chair"), STRIPPED_WARPED_STEM_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_warped_stem_chair"), new BlockItem(STRIPPED_WARPED_STEM_CHAIR, new Item.Settings().group(seatsItemGroup)));

        /* SIMPLE STRIPPED LOG CHAIRS 2 */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_oak_log_chair_2"), STRIPPED_OAK_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_oak_log_chair_2"), new BlockItem(STRIPPED_OAK_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_birch_log_chair_2"), STRIPPED_BIRCH_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_birch_log_chair_2"), new BlockItem(STRIPPED_BIRCH_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_spruce_log_chair_2"), STRIPPED_SPRUCE_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_spruce_log_chair_2"), new BlockItem(STRIPPED_SPRUCE_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_dark_oak_log_chair_2"), STRIPPED_DARK_OAK_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_dark_oak_log_chair_2"), new BlockItem(STRIPPED_DARK_OAK_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_acacia_log_chair_2"), STRIPPED_ACACIA_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_acacia_log_chair_2"), new BlockItem(STRIPPED_ACACIA_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_jungle_log_chair_2"), STRIPPED_JUNGLE_LOG_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_jungle_log_chair_2"), new BlockItem(STRIPPED_JUNGLE_LOG_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_crimson_stem_chair_2"), STRIPPED_CRIMSON_STEM_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_crimson_stem_chair_2"), new BlockItem(STRIPPED_CRIMSON_STEM_CHAIR_2, new Item.Settings().group(seatsItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_warped_stem_chair_2"), STRIPPED_WARPED_STEM_CHAIR_2);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_warped_stem_chair_2"), new BlockItem(STRIPPED_WARPED_STEM_CHAIR_2, new Item.Settings().group(seatsItemGroup)));
}
    public static void registerTables() {
        /* LOG TABLES */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oak_log_table"), OAK_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oak_log_table"), new BlockItem(OAK_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "birch_log_table"), BIRCH_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "birch_log_table"), new BlockItem(BIRCH_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "spruce_log_table"), SPRUCE_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "spruce_log_table"), new BlockItem(SPRUCE_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "dark_oak_log_table"), DARK_OAK_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "dark_oak_log_table"), new BlockItem(DARK_OAK_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "acacia_log_table"), ACACIA_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "acacia_log_table"), new BlockItem(ACACIA_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "jungle_log_table"), JUNGLE_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "jungle_log_table"), new BlockItem(JUNGLE_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "crimson_stem_table"), CRIMSON_STEM_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crimson_stem_table"), new BlockItem(CRIMSON_STEM_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "warped_stem_table"), WARPED_STEM_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "warped_stem_table"), new BlockItem(WARPED_STEM_TABLE, new Item.Settings().group(tablesItemGroup)));

        /* STRIPPED LOG TABLES */
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_oak_log_table"), STRIPPED_OAK_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_oak_log_table"), new BlockItem(STRIPPED_OAK_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_birch_log_table"), STRIPPED_BIRCH_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_birch_log_table"), new BlockItem(STRIPPED_BIRCH_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_spruce_log_table"), STRIPPED_SPRUCE_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_spruce_log_table"), new BlockItem(STRIPPED_SPRUCE_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_dark_oak_log_table"), STRIPPED_DARK_OAK_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_dark_oak_log_table"), new BlockItem(STRIPPED_DARK_OAK_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_acacia_log_table"), STRIPPED_ACACIA_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_acacia_log_table"), new BlockItem(STRIPPED_ACACIA_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_jungle_log_table"), STRIPPED_JUNGLE_LOG_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_jungle_log_table"), new BlockItem(STRIPPED_JUNGLE_LOG_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_crimson_stem_table"), STRIPPED_CRIMSON_STEM_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_crimson_stem_table"), new BlockItem(STRIPPED_CRIMSON_STEM_TABLE, new Item.Settings().group(tablesItemGroup)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "stripped_warped_stem_table"), STRIPPED_WARPED_STEM_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_warped_stem_table"), new BlockItem(STRIPPED_WARPED_STEM_TABLE, new Item.Settings().group(tablesItemGroup)));
    }

}

