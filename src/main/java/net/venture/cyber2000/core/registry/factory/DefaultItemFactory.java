package net.venture.cyber2000.core.registry.factory;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.core.registry.object.VentureItems;

import java.util.function.Supplier;

public interface DefaultItemFactory extends ObjectFactory {
    static RegistryObject<Item> create(String name, Item.Properties properties) {
        return create(name, () -> new Item(properties));
    }

    private static RegistryObject<Item> create(String name, Supplier<Item> itemSupplier) {
        return VentureItems.ITEMS.register(name, itemSupplier);
    }

    static <T extends Item> RegistryObject<T> createTyped(String name, Supplier<T> typedItemSupplier) {
        return VentureItems.ITEMS.register(name, typedItemSupplier);
    }
}
