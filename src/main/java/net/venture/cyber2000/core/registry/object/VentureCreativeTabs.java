package net.venture.cyber2000.core.registry.object;

import net.venture.cyber2000.core.util.creative.CreativeTabAdder;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import java.util.List;

public class VentureCreativeTabs {
    public static void register(BuildCreativeModeTabContentsEvent event) {
        final CreativeTabAdder tabAdder = new CreativeTabAdder(event);
        tabAdder.addAllToIngredients(List.of(
                VentureItems.FROZEN_NAUTILUS_SHELL,
                VentureItems.FROZEN_COD,
                VentureItems.FROZEN_EMERALD,
                VentureItems.FROZEN_TRIDENT,
                VentureItems.FROZEN_SALMON
        ));
    }
}
