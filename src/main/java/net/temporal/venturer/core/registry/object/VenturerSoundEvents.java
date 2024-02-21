package net.temporal.venturer.core.registry.object;

import net.minecraftforge.registries.RegistryObject;
import net.temporal.venturer.Venturer;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.temporal.venturer.core.registry.facade.VenturerSoundEventFactoryFacade;

public class VenturerSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, Venturer.MOD_ID);
    public static final VenturerSoundEventFactoryFacade SOUND_EVENT_FACTORY = VenturerSoundEventFactoryFacade.getInstance();

    public static final RegistryObject<SoundEvent> MUSIC_DISC_THAW = SOUND_EVENT_FACTORY.create("music_disc.thaw", Venturer.MOD_ID);

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
