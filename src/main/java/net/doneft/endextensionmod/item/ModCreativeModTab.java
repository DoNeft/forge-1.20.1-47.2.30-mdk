package net.doneft.endextensionmod.item;

import net.doneft.endextensionmod.EndExtensionMod;
import net.doneft.endextensionmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EndExtensionMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENDEXTENSION_TAB = CREATIVE_MODE_TABS.register("end_extension_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IRENDINGOT.get()))
                    .title(Component.translatable("creativetab.end_extension_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAWIREND.get());
                        output.accept(ModItems.IRENDINGOT.get());

                        output.accept(ModBlocks.IRENDBLOCK.get());
                        output.accept(ModBlocks.RAW_IRENDBLOCK.get());
                        output.accept(ModBlocks.IRENDREMAINS.get());
                        output.accept(ModBlocks.DEEPSLATE_IRENDREMAINS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);






    }

}
