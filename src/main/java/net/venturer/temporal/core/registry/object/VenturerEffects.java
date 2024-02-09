package net.venturer.temporal.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.common.object.effect.ImmunityEffect;
import net.venturer.temporal.core.registry.facade.VenturerEffectFactoryFacade;

public class VenturerEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Venturer.MOD_ID);
    public static final VenturerEffectFactoryFacade EFFECT_FACTORY = VenturerEffectFactoryFacade.getInstance();

    public static final RegistryObject<MobEffect> IMMUNITY = EFFECT_FACTORY.create("immunity", () -> new ImmunityEffect(MobEffectCategory.BENEFICIAL, 0xac9c5c));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
