package net.venturer.cyber2000.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.cyber2000.Venturer;
import net.venturer.cyber2000.common.object.effect.ImmunityEffect;
import net.venturer.cyber2000.core.registry.factory.DefaultEffectFactory;
import net.venturer.cyber2000.core.util.log.LoggingRegistry;

public class VenturerEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Venturer.MOD_ID);

    public static final RegistryObject<MobEffect> IMMUNITY = DefaultEffectFactory.create("immunity", () -> new ImmunityEffect(MobEffectCategory.NEUTRAL, 0xa2a389));

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(EFFECTS, "effects", eventBus);
    }
}
