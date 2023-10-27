package net.venture.cyber2000.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.util.log.LoggingRegistry;

public class VenturePotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, Venture.MOD_ID);



    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(POTIONS, "potions", eventBus);
    }
}
