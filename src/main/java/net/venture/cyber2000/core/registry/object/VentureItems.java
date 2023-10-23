package net.venture.cyber2000.core.registry.object;

import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.util.log.LoggingRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class VentureItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Venture.MOD_ID);

    public static final RegistryObject<Item> FROZEN_TRIDENT = ITEMS.register("frozen_trident", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FROZEN_EMERALD = ITEMS.register("frozen_emerald", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FROZEN_SALMON = ITEMS.register("frozen_salmon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FROZEN_COD = ITEMS.register("frozen_cod", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FROZEN_NAUTILUS_SHELL = ITEMS.register("frozen_nautilus_shell", () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(ITEMS, eventBus);
    }
}
