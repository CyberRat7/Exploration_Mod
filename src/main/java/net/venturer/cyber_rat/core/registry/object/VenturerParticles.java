package net.venturer.cyber_rat.core.registry.object;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.cyber_rat.Venturer;
import net.venturer.cyber_rat.core.registry.factory.DefaultParticleFactory;
import net.venturer.cyber_rat.core.util.log.LoggingRegistry;

public class VenturerParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, Venturer.MOD_ID);

    public static final RegistryObject<ParticleType<SimpleParticleType>> ANCIENT_STAR = DefaultParticleFactory.create("ancient_star", false);

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(PARTICLES, "particles", eventBus);
    }
}
