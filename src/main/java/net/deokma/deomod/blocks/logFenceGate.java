package net.deokma.deomod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class logFenceGate extends FenceGateBlock {

    public logFenceGate() {
        super(FabricBlockSettings.of(Material.WOOD)
                .resistance(3f)
                .hardness(2f)
                .sounds(BlockSoundGroup.WOOD));
    }
}
