package net.deokma.deomod.world.village;

import fzzyhmstrs.structurized_reborn.impl.FabricStructurePoolRegistry;
import net.deokma.deomod.DeoMod;
import net.minecraft.util.Identifier;
public class VillageAdditions {
    // Using https://github.com/fzzyhmstrs/structurized-reborn (Under MIT License)
    public static void registerNewVillageStructures() {
        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/plains/houses"),
                new Identifier(DeoMod.MOD_ID, "merchant_house"),
                30
        );
    }
}