package net.venturer.temporal.core.registry.object;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.core.registry.factory.ParticleFactory;
import net.venturer.temporal.core.util.log.LoggingRegistry;

public class VenturerParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, Venturer.MOD_ID);

    public static final RegistryObject<ParticleType<SimpleParticleType>> ANCIENT_STAR = ParticleFactory.create("ancient_star", false);

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(PARTICLES, "particles", eventBus);
    }
}
