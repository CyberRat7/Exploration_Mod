package net.venturer.temporal.core.registry.object;

import com.temporal.api.core.event.tab.SimpleTabAdder;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class VenturerCreativeTabs {
    public static void register(BuildCreativeModeTabContentsEvent event) {
        new SimpleTabAdder(event)
                .addAllToTab(CreativeModeTabs.INGREDIENTS, VenturerItems.FROZEN_NAUTILUS_SHELL, VenturerItems.FROZEN_COD,
                        VenturerItems.FROZEN_EMERALD, VenturerItems.FROZEN_TRIDENT,
                        VenturerItems.FROZEN_SALMON, VenturerItems.FROZEN_PUFFERFISH,
                        VenturerItems.FROZEN_IRON_HORSE_ARMOR, VenturerItems.NETTLE_LEAVES,
                        VenturerItems.CHILL_ARMOR_TRIM_SMITHING_TEMPLATE)
                .addAllToTab(CreativeModeTabs.TOOLS_AND_UTILITIES, VenturerItems.MUSIC_DISC_THAW)
                .addAllToTab(CreativeModeTabs.FOOD_AND_DRINKS, VenturerItems.NETTLE_SOUP)
                .addAllToTab(CreativeModeTabs.NATURAL_BLOCKS, VenturerBlocks.BAG_OF_NETTLE_LEAVES);
    }
}
