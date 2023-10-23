package net.explorationmod.cyber2000.core.registry.factory.item;

import net.explorationmod.cyber2000.core.registry.factory.DefaultItemFactory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public interface BowlFoodItemFactory extends DefaultItemFactory {
    static RegistryObject<BowlFoodItem> create(String name, int nutrition, float saturation) {
        return DefaultItemFactory.createTyped(name, () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build())));

    }
}
