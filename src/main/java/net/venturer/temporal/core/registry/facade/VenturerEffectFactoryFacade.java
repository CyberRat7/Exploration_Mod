package net.venturer.temporal.core.registry.facade;

import com.temporal.api.core.registry.factory.common.EffectFactory;
import net.venturer.temporal.core.registry.object.VenturerEffects;

public class VenturerEffectFactoryFacade extends EffectFactory {
    private static volatile VenturerEffectFactoryFacade instance;

    public VenturerEffectFactoryFacade() {
        super(VenturerEffects.EFFECTS);
    }

    public static VenturerEffectFactoryFacade getInstance() {
        if (instance == null) {
            synchronized (VenturerEffectFactoryFacade.class) {
                if (instance == null) {
                    instance = new VenturerEffectFactoryFacade();
                }
            }
        }

        return instance;
    }
}
