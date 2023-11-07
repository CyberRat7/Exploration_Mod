package net.venture.cyber2000.core.registry.factory.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.registry.factory.DefaultItemFactory;

import java.util.function.Supplier;

public interface ArmorFactory extends DefaultItemFactory {
    static RegistryObject<SmithingTemplateItem> create(String name) {
        return create(name, new ResourceLocation(Venture.MOD_ID, name));
    }

    private static RegistryObject<SmithingTemplateItem> create(String name, ResourceLocation resourceLocation) {
        return DefaultItemFactory.createTyped(name, () -> SmithingTemplateItem.createArmorTrimTemplate(resourceLocation));
    }
}
