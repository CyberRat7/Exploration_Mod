package net.temporal.venturer.core.registry.facade;

import com.temporal.api.core.registry.factory.common.ParticleFactory;
import net.temporal.venturer.core.registry.object.VenturerParticles;

public class VenturerParticleFactoryFacade extends ParticleFactory {
    private static volatile VenturerParticleFactoryFacade instance;

    public VenturerParticleFactoryFacade() {
        super(VenturerParticles.PARTICLES);
    }

    public static VenturerParticleFactoryFacade getInstance() {
        if (instance == null) {
            synchronized (VenturerParticleFactoryFacade.class) {
                if (instance == null) {
                    instance = new VenturerParticleFactoryFacade();
                }
            }
        }

        return instance;
    }
}
