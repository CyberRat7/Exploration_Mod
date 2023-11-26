package net.venturer.temporal.core.registry.factory;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.venturer.temporal.core.registry.object.VenturerPotions.POTIONS;

public interface DefaultPotionFactory extends ObjectFactory {
    static RegistryObject<Potion> create(String name, MobEffectInstance mobEffectInstance) {
        return POTIONS.register(name, () -> new Potion(mobEffectInstance));
    }
     static RegistryObject<Potion> create(String id, Supplier<MobEffect> effect, int duration) {
        return POTIONS.register(id, () -> new Potion(new MobEffectInstance(effect.get(), duration)));
    }
    private static RegistryObject<Potion> create(String name, Supplier<Potion> potionSupplier) {
        return POTIONS.register(name, potionSupplier);
    }
}
