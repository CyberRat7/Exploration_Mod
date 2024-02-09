package net.venturer.temporal.core.registry.facade;

import com.temporal.api.core.registry.factory.common.PotionFactory;
import net.venturer.temporal.core.registry.object.VenturerPotions;

public class VenturerPotionFactoryFacade extends PotionFactory {
    private static volatile VenturerPotionFactoryFacade instance;

    public VenturerPotionFactoryFacade() {
        super(VenturerPotions.POTIONS);
    }

    public static VenturerPotionFactoryFacade getInstance() {
        if (instance == null) {
            synchronized (VenturerPotionFactoryFacade.class) {
                if (instance == null) {
                    instance = new VenturerPotionFactoryFacade();
                }
            }
        }

        return instance;
    }
}
