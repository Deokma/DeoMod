package net.deokma.deomod.registry;

import net.deokma.deomod.DeoMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.deokma.deomod.blocks.*;
import net.deokma.deomod.blocks.block_entities.logBench_BlockEntity;
import net.deokma.deomod.blocks.block_entities.logSmallStool_BlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class blockRegistry {

    public static final String MOD_ID = "deomod";

    public static final Block BEACH_CHAIR = new logBeachChair();
    public static final Block WOODEN_COFFEE_TABLE = new logCoffeeTable();
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block RUBY_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(3,7));

    public static BlockEntityType<logBench_BlockEntity> LOG_BENCH_BLOCK_ENTITY;
    public static BlockEntityType<logSmallStool_BlockEntity> LOG_SMALL_STOOL_BLOCK_ENTITY;
    public static void registerChairs() {

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "beach_chair"), BEACH_CHAIR);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "beach_chair"), new BlockItem(BEACH_CHAIR, new Item.Settings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "wooden_coffee_table"), WOODEN_COFFEE_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wooden_coffee_table"), new BlockItem(WOODEN_COFFEE_TABLE, new Item.Settings().group(ItemGroup.DECORATIONS)));


        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

    }

}

