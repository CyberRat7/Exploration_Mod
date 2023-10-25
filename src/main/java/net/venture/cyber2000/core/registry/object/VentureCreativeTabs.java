package net.venture.cyber2000.core.registry.object;

import net.venture.cyber2000.core.util.creative.CreativeTabAdder;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import java.util.List;

public class VentureCreativeTabs {
    public static void register(BuildCreativeModeTabContentsEvent event) {
        CreativeTabAdder tabAdder = new CreativeTabAdder(event);
        tabAdder.addAllToIngredients(List.of(
                VentureItems.FROZEN_NAUTILUS_SHELL,
                VentureItems.FROZEN_COD,
                VentureItems.FROZEN_EMERALD,
                VentureItems.FROZEN_TRIDENT,
                VentureItems.FROZEN_SALMON,
                VentureItems.FROZEN_PUFFERFISH,
                VentureItems.FROZEN_IRON_HORSE_ARMOR,
                VentureItems.NETTLE_LEAVES
        ));
        tabAdder.addAllToTools(List.of(
                VentureItems.FROZEN_DISC
        ));
        tabAdder.addAllToCombat(List.of(
                VentureItems.ANCIENT_BOW
        ));
        tabAdder.addAllToFood(List.of(
                VentureItems.NETTLE_SOUP
        ));
        tabAdder.addAllToNaturalBlocks(List.of(
                VentureBlocks.STINGING_NETTLE
        ));
    }
}
