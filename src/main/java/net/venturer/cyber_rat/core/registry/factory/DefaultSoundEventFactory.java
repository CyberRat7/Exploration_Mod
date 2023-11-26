package net.venturer.cyber_rat.core.registry.factory;

import net.venturer.cyber_rat.Venturer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

import static net.venturer.cyber_rat.core.registry.object.VenturerSoundEvents.SOUND_EVENTS;

public interface DefaultSoundEventFactory extends ObjectFactory {
    static RegistryObject<SoundEvent> create(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(Venturer.MOD_ID, name)
        ));
    }
}
