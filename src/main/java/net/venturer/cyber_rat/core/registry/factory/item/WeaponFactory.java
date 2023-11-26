package net.venturer.cyber_rat.core.registry.factory.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.cyber_rat.common.object.item.AncientArrowItem;
import net.venturer.cyber_rat.common.object.item.AncientBowItem;
import net.venturer.cyber_rat.core.registry.factory.DefaultItemFactory;

public interface WeaponFactory extends DefaultItemFactory {
    static RegistryObject<Item> createAncientBow(String name, Item.Properties properties) {
        return DefaultItemFactory.createTyped(name, () -> new AncientBowItem(properties));
    }

    static RegistryObject<Item> createAncientArrow(String name, Item.Properties properties) {
        return DefaultItemFactory.createTyped(name, () -> new AncientArrowItem(properties));
    }
}
