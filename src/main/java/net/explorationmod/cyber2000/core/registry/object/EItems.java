package net.explorationmod.cyber2000.core.registry.object;

import net.explorationmod.cyber2000.ExplorationMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ExplorationMod.MOD_ID);

    public static final RegistryObject<Item> TEST = ITEMS.register("test", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(ITEMS, eventBus);
    }
}
