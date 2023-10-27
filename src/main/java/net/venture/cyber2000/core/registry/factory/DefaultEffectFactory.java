package net.venture.cyber2000.core.registry.factory;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.venture.cyber2000.core.registry.object.VentureEffects.EFFECTS;

public interface DefaultEffectFactory extends ObjectFactory {
    static <T extends MobEffect> RegistryObject<MobEffect> create(String name, Supplier<MobEffect> mobEffectSupplier) {
        return EFFECTS.register(name, mobEffectSupplier);
    }
}
