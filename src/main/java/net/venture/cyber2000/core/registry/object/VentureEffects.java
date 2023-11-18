package net.venture.cyber2000.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.common.object.effect.ImmunityEffect;
import net.venture.cyber2000.core.registry.factory.DefaultEffectFactory;
import net.venture.cyber2000.core.util.log.LoggingRegistry;

public class VentureEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Venture.MOD_ID);

    public static final RegistryObject<MobEffect> IMMUNITY = DefaultEffectFactory.create("immunity", () -> new ImmunityEffect(MobEffectCategory.BENEFICIAL, 0xac9c5c));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(EFFECTS, "effects", eventBus);
    }
}
