package net.venture.cyber2000.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.util.log.LoggingRegistry;

public class VentureEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Venture.MOD_ID);



    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(EFFECTS, "effects", eventBus);
    }
}
