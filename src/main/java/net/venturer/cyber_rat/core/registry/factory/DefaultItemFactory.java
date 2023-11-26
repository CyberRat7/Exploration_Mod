package net.venturer.cyber_rat.core.registry.factory;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.venturer.cyber_rat.core.registry.object.VenturerItems.ITEMS;

public interface DefaultItemFactory extends ObjectFactory {
    static RegistryObject<Item> create(String name) {
        return create(name, () -> new Item(new Item.Properties()));
    }

    static RegistryObject<Item> create(String name, Item.Properties properties) {
        return create(name, () -> new Item(properties));
    }

    private static RegistryObject<Item> create(String name, Supplier<Item> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    static <T extends Item> RegistryObject<T> createTyped(String name, Supplier<T> typedItemSupplier) {
        return ITEMS.register(name, typedItemSupplier);
    }
}
