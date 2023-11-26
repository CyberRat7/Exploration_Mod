package net.venturer.temporal.core.registry.factory.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.core.registry.factory.ItemFactory;

public interface ArmorFactory extends ItemFactory {
    static RegistryObject<SmithingTemplateItem> createSmithingTemplate(String name) {
        return createSmithingTemplate(name, new ResourceLocation(Venturer.MOD_ID, name));
    }

    private static RegistryObject<SmithingTemplateItem> createSmithingTemplate(String name, ResourceLocation resourceLocation) {
        return ItemFactory.createTyped(name, () -> SmithingTemplateItem.createArmorTrimTemplate(resourceLocation));
    }
}
