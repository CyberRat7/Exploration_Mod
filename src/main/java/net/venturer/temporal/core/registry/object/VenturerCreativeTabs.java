package net.venturer.temporal.core.registry.object;

import net.venturer.temporal.core.util.creative.CreativeTabAdder;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.venturer.temporal.core.util.creative.CreativeTabBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class VenturerCreativeTabs {
    public static void register(BuildCreativeModeTabContentsEvent event) {
        CreativeTabBuilder.create(new CreativeTabAdder(event))
                .processIngredients(VenturerItems.NETTLE_LEAVES, VenturerItems.COYOTE_FUR, VenturerItems.CHILL_ARMOR_TRIM_SMITHING_TEMPLATE)
                .processTools(VenturerItems.MUSIC_DISC_THAW)
                .processFood(VenturerItems.NETTLE_SOUP)
                .processNaturalBlocks(VenturerBlocks.STINGING_NETTLE, VenturerBlocks.BAG_OF_NETTLE_LEAVES)
                .build();

    }
}
