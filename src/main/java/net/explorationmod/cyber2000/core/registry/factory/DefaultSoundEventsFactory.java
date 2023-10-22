package net.explorationmod.cyber2000.core.registry.factory;

import net.explorationmod.cyber2000.Venture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

import static net.explorationmod.cyber2000.core.registry.object.VentureSoundEvents.SOUND_EVENTS;

public interface DefaultSoundEventsFactory extends ObjectFactory {
    static RegistryObject<SoundEvent> create(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(Venture.MOD_ID, name)
        ));
    }
}
