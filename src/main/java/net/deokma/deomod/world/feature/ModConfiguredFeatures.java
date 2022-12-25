package net.deokma.deomod.world.feature;//package net.deokma.deo.world.feature;

import net.deokma.deomod.DeoMod;
//import net.deokma.deomod.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
//import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
//    public static final List<OreFeatureConfig.Target> OVERWORLD_RUBY_ORES = List.of(
//            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.getDefaultState()));
//

//    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> RUBY_ORE =
//            ConfiguredFeatures.register("ruby_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 5));

    public static void registerConfiguredFeatures() {
        DeoMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + DeoMod.MOD_ID);
    }
}