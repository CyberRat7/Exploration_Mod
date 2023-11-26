package net.venturer.temporal.core.registry.factory.item;

import net.venturer.temporal.core.registry.factory.DefaultItemFactory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public interface EdibleItemFactory extends DefaultItemFactory {
    static RegistryObject<BowlFoodItem> createBowl(String name, int nutrition, float saturation) {
        return DefaultItemFactory.createTyped(name, () -> new BowlFoodItem(
                new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build())
        ));
    }

    static RegistryObject<Item> createFood(String name, int nutrition, float saturation) {
        return DefaultItemFactory.create(name, new Item.Properties().food(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build()));
    }
}
