package net.explorationmod.cyber2000.core.registry.object;

import net.explorationmod.cyber2000.ExplorationMod;
import net.explorationmod.cyber2000.core.registry.factory.DefaultPaintingFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(Registries.PAINTING_VARIANT, ExplorationMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> EARTH = DefaultPaintingFactory.create32x32("world");

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(PAINTING_VARIANTS, eventBus);
    }
}
