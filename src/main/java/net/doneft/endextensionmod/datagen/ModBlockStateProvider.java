package net.doneft.endextensionmod.datagen;

import net.doneft.endextensionmod.EndExtensionMod;
import net.doneft.endextensionmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,ExistingFileHelper exFileHelper) {
        super(output, EndExtensionMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DEEPSLATE_IRENDREMAINS);
        blockWithItem(ModBlocks.IRENDBLOCK);
        blockWithItem(ModBlocks.IRENDREMAINS);
        blockWithItem(ModBlocks.RAW_IRENDBLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
