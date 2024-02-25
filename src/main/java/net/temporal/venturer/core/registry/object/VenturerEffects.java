package net.temporal.venturer.core.registry.object;

import com.temporal.api.core.registry.factory.common.EffectFactory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.temporal.venturer.common.object.effect.ImmunityEffect;

public class VenturerEffects {
    public static final EffectFactory EFFECT_FACTORY = EffectFactory.getInstance();

    public static final RegistryObject<MobEffect> IMMUNITY = EFFECT_FACTORY.create("immunity", () -> new ImmunityEffect(MobEffectCategory.BENEFICIAL, 0xac9c5c));

    public static void register(IEventBus eventBus) {
        EFFECT_FACTORY.register(eventBus);
    }
}
