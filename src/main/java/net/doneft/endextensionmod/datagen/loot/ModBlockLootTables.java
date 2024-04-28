package net.doneft.endextensionmod.datagen.loot;

import net.doneft.endextensionmod.block.ModBlocks;
import net.doneft.endextensionmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RAW_IRENDBLOCK.get());
        this.dropSelf(ModBlocks.IRENDBLOCK.get());

        this.add(ModBlocks.IRENDREMAINS.get(),
                block -> createOreDrop(ModBlocks.IRENDREMAINS.get(), ModItems.RAWIREND.get()));

        this.add(ModBlocks.DEEPSLATE_IRENDREMAINS.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_IRENDREMAINS.get(), ModItems.RAWIREND.get()));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
