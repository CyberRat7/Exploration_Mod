package net.temporal.venturer.core.registry.facade;

import com.temporal.api.core.registry.factory.common.PaintingFactory;
import net.temporal.venturer.core.registry.object.VenturerPaintings;

public class VenturerPaintingFactoryFacade extends PaintingFactory {
    private static volatile VenturerPaintingFactoryFacade instance;

    public VenturerPaintingFactoryFacade() {
        super(VenturerPaintings.PAINTING_VARIANTS);
    }

    public static VenturerPaintingFactoryFacade getInstance() {
        if (instance == null) {
            synchronized (VenturerPaintingFactoryFacade.class) {
                if (instance == null) {
                    instance = new VenturerPaintingFactoryFacade();
                }
            }
        }

        return instance;
    }
}
