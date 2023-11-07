package net.venture.cyber2000.core.registry.factory;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.Venture;

import java.util.function.Supplier;

import static net.venture.cyber2000.core.registry.object.VentureTrimPatterns.TRIM_PATTERNS;

public interface DefaultTrimPatternFactory extends ObjectFactory {
    static RegistryObject<TrimPattern> create(String name, Holder<Item> holder, String description) {
        return create(name, new ResourceLocation(Venture.MOD_ID, "/textures/trims/models/armor"), holder, Component.translatable(description));
    }

    private static RegistryObject<TrimPattern> create(String name, ResourceLocation resourceLocation, Holder<Item> holder, Component description) {
        return create(name, () -> new TrimPattern(resourceLocation, holder, description));
    }

    private static RegistryObject<TrimPattern> create(String name, Supplier<TrimPattern> patternSupplier) {
        return TRIM_PATTERNS.register(name, patternSupplier);
    }
}
