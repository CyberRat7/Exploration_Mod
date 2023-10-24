package net.venture.cyber2000.core.registry.object;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.registry.factory.DefaultParticleFactory;
import net.venture.cyber2000.core.util.log.LoggingRegistry;

public class VentureParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, Venture.MOD_ID);

    public static final RegistryObject<ParticleType<SimpleParticleType>> ANCIENT_STAR = DefaultParticleFactory.create("ancient_star", false);

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(PARTICLES, "particles", eventBus);
    }
}
