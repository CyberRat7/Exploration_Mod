package net.venturer.cyber_rat.core.registry.factory;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.RegistryObject;

import static net.venturer.cyber_rat.core.registry.object.VenturerParticles.PARTICLES;

public interface DefaultParticleFactory extends ObjectFactory {
    static RegistryObject<ParticleType<SimpleParticleType>> create(String name, boolean overrideLimiter) {
        return PARTICLES.register(name, () -> new SimpleParticleType(overrideLimiter));
    }
}
