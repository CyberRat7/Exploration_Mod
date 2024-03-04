package net.temporal.venturer.core.registry.object;

import com.temporal.api.core.registry.factory.common.SoundEventFactory;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class VenturerSoundEvents {
    public static final SoundEventFactory SOUND_EVENT_FACTORY = SoundEventFactory.getInstance();

    public static final RegistryObject<SoundEvent> MUSIC_DISC_THAW = SOUND_EVENT_FACTORY.create("music_disc.thaw");

    public static void register(IEventBus eventBus) {
        SOUND_EVENT_FACTORY.register(eventBus);
    }
}
