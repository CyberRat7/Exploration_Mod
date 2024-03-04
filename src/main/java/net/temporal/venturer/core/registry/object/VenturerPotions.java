package net.temporal.venturer.core.registry.object;

import com.temporal.api.core.registry.factory.common.PotionFactory;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class VenturerPotions {
    public static final PotionFactory POTION_FACTORY = PotionFactory.getInstance();

    public static final RegistryObject<Potion> IMMUNITY_POTION = POTION_FACTORY.create("immunity_potion", VenturerEffects.IMMUNITY, 3600);
    public static final RegistryObject<Potion> LONG_IMMUNITY_POTION = POTION_FACTORY.create("long_immunity_potion", VenturerEffects.IMMUNITY, 9600);

    public static void register(IEventBus eventBus) {
        POTION_FACTORY.register(eventBus);
    }
}
