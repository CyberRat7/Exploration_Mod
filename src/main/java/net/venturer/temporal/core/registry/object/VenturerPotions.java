package net.venturer.temporal.core.registry.object;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.core.registry.facade.VenturerPotionFactoryFacade;

public class VenturerPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, Venturer.MOD_ID);
    public static final VenturerPotionFactoryFacade POTION_FACTORY = VenturerPotionFactoryFacade.getInstance();

    public static final RegistryObject<Potion> IMMUNITY_POTION = POTION_FACTORY.create("immunity_potion", VenturerEffects.IMMUNITY, 3600);
    public static final RegistryObject<Potion> LONG_IMMUNITY_POTION = POTION_FACTORY.create("long_immunity_potion", VenturerEffects.IMMUNITY, 9600);

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
