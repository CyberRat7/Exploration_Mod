package net.venturer.temporal.core.registry.object;

import net.venturer.temporal.core.util.creative.CreativeTabAdder;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.venturer.temporal.core.util.creative.CreativeTabBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class VenturerCreativeTabs {
    public static void register(BuildCreativeModeTabContentsEvent event) {
        CreativeTabBuilder.create(new CreativeTabAdder(event))
                .processIngredients(VenturerItems.FROZEN_NAUTILUS_SHELL, VenturerItems.FROZEN_COD, VenturerItems.FROZEN_EMERALD, VenturerItems.FROZEN_TRIDENT,
                        VenturerItems.FROZEN_SALMON, VenturerItems.FROZEN_PUFFERFISH, VenturerItems.FROZEN_IRON_HORSE_ARMOR,
                        VenturerItems.NETTLE_LEAVES, VenturerItems.CHILL_ARMOR_TRIM_SMITHING_TEMPLATE)
                .processTools(VenturerItems.MUSIC_DISC_THAW)
                .processFood(VenturerItems.NETTLE_SOUP)
                .processNaturalBlocks(VenturerBlocks.STINGING_NETTLE, VenturerBlocks.BAG_OF_NETTLE_LEAVES)
                .build();

    }
}
