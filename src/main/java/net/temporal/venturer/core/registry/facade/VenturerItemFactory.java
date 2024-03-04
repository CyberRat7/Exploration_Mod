package net.temporal.venturer.core.registry.facade;

import com.temporal.api.core.registry.factory.common.ItemFactory;
import com.temporal.api.core.registry.factory.extension.item.*;

public class VenturerItemFactory extends ItemFactory implements ArrowExtension, BowExtension, BowlExtension, MusicDiscExtension, SmithingTemplateExtension, SpawnEggExtension {
    private static volatile VenturerItemFactory instance;

    public static VenturerItemFactory getInstance() {
        if (instance == null) {
            synchronized (VenturerItemFactory.class) {
                if (instance == null) {
                    instance = new VenturerItemFactory();
                }
            }
        }

        return instance;
    }
}
