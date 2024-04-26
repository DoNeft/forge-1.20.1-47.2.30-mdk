package net.doneft.endextensionmod.item;

import net.doneft.endextensionmod.EndExtensionMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EndExtensionMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> RAWIREND = ITEMS.register("rawirend",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRENDINGOT = ITEMS.register("irendingot",
            () -> new Item(new Item.Properties()));
}
