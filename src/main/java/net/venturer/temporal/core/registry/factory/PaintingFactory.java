package net.venturer.temporal.core.registry.factory;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.RegistryObject;

import static net.venturer.temporal.core.registry.object.VenturerPaintings.PAINTING_VARIANTS;

public interface PaintingFactory extends ObjectFactory {
    static RegistryObject<PaintingVariant> create16x16(String name) {
        return create(name, 16, 16);
    }

    static RegistryObject<PaintingVariant> create16x32(String name) {
        return create(name, 16, 32);
    }

    static RegistryObject<PaintingVariant> create32x16(String name) {
        return create(name, 32, 16);
    }

    static RegistryObject<PaintingVariant> create32x32(String name) {
        return create(name, 32, 32);
    }

    private static RegistryObject<PaintingVariant> create(String name, int width, int height) {
        return PAINTING_VARIANTS.register(name, () -> new PaintingVariant(width, height));
    }
}
