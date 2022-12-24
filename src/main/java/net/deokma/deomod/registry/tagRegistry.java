package net.deokma.deomod.registry;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class tagRegistry {
    public static class Blocks {
        public static final TagKey<Block> BENCHES = createTag("benches");
        public static final TagKey<Block> HIGH_BENCHES = createTag("high_benches");
        public static final TagKey<Block> CHAIRS = createTag("chairs");
        public static final TagKey<Block> BENCH_CHAIRS = createTag("bench_chair");
        public static final TagKey<Block> SMALL_STOOLS = createTag("small_stools");
        public static final TagKey<Block> TABLES = createTag("tables");

        public static final String MOD_ID = "deomod";


        private static TagKey<Block> createTag(String tagName)
        {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(MOD_ID, tagName));
        }
    }
}
