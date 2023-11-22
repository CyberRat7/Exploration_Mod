package net.venturer.cyber2000.core.registry.object;

import net.minecraftforge.registries.RegistryObject;
import net.venturer.cyber2000.Venturer;
import net.venturer.cyber2000.core.registry.factory.DefaultSoundEventFactory;
import net.venturer.cyber2000.core.util.log.LoggingRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class VenturerSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, Venturer.MOD_ID);

    public static final RegistryObject<SoundEvent> MUSIC_DISC_THAW = DefaultSoundEventFactory.create("music_disc.thaw");

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(SOUND_EVENTS, "sounds", eventBus);
    }
}
