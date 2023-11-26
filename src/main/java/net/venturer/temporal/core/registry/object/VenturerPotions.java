package net.venturer.temporal.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.core.registry.factory.DefaultPotionFactory;
import net.venturer.temporal.core.util.log.LoggingRegistry;

public class VenturerPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, Venturer.MOD_ID);

    public static final RegistryObject<Potion> IMMUNITY_POTION = DefaultPotionFactory.create("immunity_potion", VenturerEffects.IMMUNITY, 3600);
    public static final RegistryObject<Potion> LONG_IMMUNITY_POTION = DefaultPotionFactory.create("long_immunity_potion", VenturerEffects.IMMUNITY, 9600);

    public static void register(IEventBus eventBus) {
        LoggingRegistry.register(POTIONS, "potions", eventBus);
    }
}
