package net.doneft.endextensionmod.util;

import net.doneft.endextensionmod.EndExtensionMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> END_ORES = tag("end_ores");



        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(EndExtensionMod.MOD_ID, name));
        }
    }

    public static class Items {



        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(EndExtensionMod.MOD_ID, name));
        }
    }

}
