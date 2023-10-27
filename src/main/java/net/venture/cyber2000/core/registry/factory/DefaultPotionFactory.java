package net.venture.cyber2000.core.registry.factory;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.venture.cyber2000.core.registry.object.VenturePotions.POTIONS;

public interface DefaultPotionFactory extends ObjectFactory {
    static RegistryObject<Potion> create(String name, MobEffectInstance mobEffectInstance) {
        return POTIONS.register(name, () -> new Potion(mobEffectInstance));
    }

    private static RegistryObject<Potion> create(String name, Supplier<Potion> potionSupplier) {
        return POTIONS.register(name, potionSupplier);
    }
}
