package net.explorationmod.cyber2000.core.registry.factory;

import net.explorationmod.cyber2000.core.registry.factory.ObjectFactory;
import net.explorationmod.cyber2000.core.registry.object.EPaintings;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.RegistryObject;

public interface DefaultPaintingFactory extends ObjectFactory {
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
        return EPaintings.PAINTING_VARIANTS.register(name, () -> new PaintingVariant(width, height));
    }
}
