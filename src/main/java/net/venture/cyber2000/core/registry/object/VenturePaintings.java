package net.venture.cyber2000.core.registry.object;

import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.registry.factory.DefaultPaintingFactory;
import net.venture.cyber2000.core.util.log.LoggingRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class VenturePaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(Registries.PAINTING_VARIANT, Venture.MOD_ID);

    // TODO: 22.10.2023 Future plans
    public static final RegistryObject<PaintingVariant> EARTH = DefaultPaintingFactory.create32x32("world");

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(PAINTING_VARIANTS, eventBus);
    }
}
