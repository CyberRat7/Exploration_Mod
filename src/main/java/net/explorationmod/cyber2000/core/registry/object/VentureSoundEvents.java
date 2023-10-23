package net.explorationmod.cyber2000.core.registry.object;

import net.explorationmod.cyber2000.Venture;
import net.explorationmod.cyber2000.core.registry.factory.DefaultSoundEventsFactory;
import net.explorationmod.cyber2000.core.util.log.LoggingRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class VentureSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, Venture.MOD_ID);

    public static final RegistryObject<SoundEvent> FROZEN_DISC_SOUND = DefaultSoundEventsFactory.create("frozen_disc_sound");

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(SOUND_EVENTS, eventBus);
    }
}
