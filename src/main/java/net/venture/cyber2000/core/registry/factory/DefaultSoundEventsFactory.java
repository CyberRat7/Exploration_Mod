package net.venture.cyber2000.core.registry.factory;

import net.venture.cyber2000.Venture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.core.registry.object.VentureSoundEvents;

public interface DefaultSoundEventsFactory extends ObjectFactory {
    static RegistryObject<SoundEvent> create(String name) {
        return VentureSoundEvents.SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(Venture.MOD_ID, name)
        ));
    }
}
