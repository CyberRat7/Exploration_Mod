package net.venturer.temporal.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.common.object.effect.ImmunityEffect;
import net.venturer.temporal.core.registry.factory.EffectFactory;
import net.venturer.temporal.core.util.log.LoggingRegistry;

public class VenturerEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Venturer.MOD_ID);

    public static final RegistryObject<MobEffect> IMMUNITY = EffectFactory.create("immunity", () -> new ImmunityEffect(MobEffectCategory.BENEFICIAL, 0xac9c5c));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(EFFECTS, "effects", eventBus);
    }
}
