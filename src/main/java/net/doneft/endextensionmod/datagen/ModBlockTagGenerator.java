package net.doneft.endextensionmod.datagen;

import net.doneft.endextensionmod.EndExtensionMod;
import net.doneft.endextensionmod.block.ModBlocks;
import net.doneft.endextensionmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EndExtensionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.END_ORES)
                .add(ModBlocks.IRENDREMAINS.get(),
                        ModBlocks.DEEPSLATE_IRENDREMAINS.get()).addTag(Tags.Blocks.ORES);


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_IRENDREMAINS.get(),
                        ModBlocks.IRENDREMAINS.get(),
                        ModBlocks.IRENDBLOCK.get(),
                        ModBlocks.RAW_IRENDBLOCK.get());


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DEEPSLATE_IRENDREMAINS.get(),
                        ModBlocks.IRENDBLOCK.get(),
                        ModBlocks.IRENDREMAINS.get(),
                        ModBlocks.RAW_IRENDBLOCK.get());

    }
}
