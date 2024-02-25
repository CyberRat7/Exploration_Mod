package net.temporal.venturer.core.registry.object;

import com.temporal.api.core.registry.factory.common.ParticleFactory;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class VenturerParticles {
    public static final ParticleFactory PARTICLE_FACTORY = ParticleFactory.getInstance();

    public static final RegistryObject<ParticleType<SimpleParticleType>> ANCIENT_STAR = PARTICLE_FACTORY.create("ancient_star", false);

    public static void register(IEventBus eventBus) {
        PARTICLE_FACTORY.register(eventBus);
    }
}
