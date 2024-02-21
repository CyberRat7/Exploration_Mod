package net.temporal.venturer.core.registry.object;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.temporal.venturer.Venturer;
import net.temporal.venturer.core.registry.facade.VenturerParticleFactoryFacade;

public class VenturerParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, Venturer.MOD_ID);
    public static final VenturerParticleFactoryFacade PARTICLE_FACTORY = VenturerParticleFactoryFacade.getInstance();

    public static final RegistryObject<ParticleType<SimpleParticleType>> ANCIENT_STAR = PARTICLE_FACTORY.create("ancient_star", false);

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}
