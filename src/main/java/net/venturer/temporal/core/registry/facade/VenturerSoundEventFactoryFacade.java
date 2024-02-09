package net.venturer.temporal.core.registry.facade;

import com.temporal.api.core.registry.factory.common.SoundEventFactory;
import net.venturer.temporal.core.registry.object.VenturerSoundEvents;

public class VenturerSoundEventFactoryFacade extends SoundEventFactory {
    private static volatile VenturerSoundEventFactoryFacade instance;

    public VenturerSoundEventFactoryFacade() {
        super(VenturerSoundEvents.SOUND_EVENTS);
    }

    public static VenturerSoundEventFactoryFacade getInstance() {
        if (instance == null) {
            synchronized (VenturerSoundEventFactoryFacade.class) {
                if (instance == null) {
                    instance = new VenturerSoundEventFactoryFacade();
                }
            }
        }

        return instance;
    }
}
