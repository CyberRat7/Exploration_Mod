package net.explorationmod.cyber2000.core.registry.factory;

import net.explorationmod.cyber2000.core.registry.object.EItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public interface DefaultItemFactory extends ObjectFactory {
    static RegistryObject<Item> create(String name, Item.Properties properties) {
        return create(name, () -> new Item(properties));
    }

    private static RegistryObject<Item> create(String name, Supplier<Item> itemSupplier) {
        return EItems.ITEMS.register(name, itemSupplier);
    }
}
