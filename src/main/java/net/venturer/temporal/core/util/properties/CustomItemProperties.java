package net.venturer.temporal.core.util.properties;

import com.temporal.api.core.properties.TemporalItemProperties;
import net.venturer.temporal.core.registry.object.VenturerBlocks;
import net.venturer.temporal.core.registry.object.VenturerItems;

public class CustomItemProperties {
    public static void addCustomItemProperties() {
        TemporalItemProperties.putCompostable(VenturerBlocks.STINGING_NETTLE.get().asItem(), 0.65f);
        TemporalItemProperties.makeBow(VenturerItems.ANCIENT_BOW.get());
    }
}
