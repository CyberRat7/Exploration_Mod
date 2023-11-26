package net.venturer.cyber_rat.core.registry.factory;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.venturer.cyber_rat.core.registry.object.VenturerEffects.EFFECTS;

public interface DefaultEffectFactory extends ObjectFactory {
    static <T extends MobEffect> RegistryObject<MobEffect> create(String name, Supplier<MobEffect> mobEffectSupplier) {
        return EFFECTS.register(name, mobEffectSupplier);
    }
}
