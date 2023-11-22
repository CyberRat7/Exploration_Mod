package net.venturer.cyber2000.core.registry.factory.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.cyber2000.Venturer;
import net.venturer.cyber2000.core.registry.factory.DefaultItemFactory;

public interface ArmorFactory extends DefaultItemFactory {
    static RegistryObject<SmithingTemplateItem> create(String name) {
        return create(name, new ResourceLocation(Venturer.MOD_ID, name));
    }

    private static RegistryObject<SmithingTemplateItem> create(String name, ResourceLocation resourceLocation) {
        return DefaultItemFactory.createTyped(name, () -> SmithingTemplateItem.createArmorTrimTemplate(resourceLocation));
    }
}
