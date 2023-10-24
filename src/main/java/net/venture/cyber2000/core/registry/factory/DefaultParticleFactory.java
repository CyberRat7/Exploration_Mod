package net.venture.cyber2000.core.registry.factory;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.RegistryObject;

import static net.venture.cyber2000.core.registry.object.VentureParticles.PARTICLES;

public interface DefaultParticleFactory extends ObjectFactory {
    static RegistryObject<ParticleType<SimpleParticleType>> create(String name, boolean overrideLimiter) {
        return PARTICLES.register(name, () -> new SimpleParticleType(overrideLimiter));
    }
}
