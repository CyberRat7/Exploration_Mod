package net.temporal.venturer;

import com.mojang.logging.LogUtils;
import com.temporal.api.core.event.tab.SimpleTabAdder;
import net.minecraft.world.item.CreativeModeTabs;
import net.temporal.venturer.core.registry.object.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Venturer.MOD_ID)
public class Venturer {
    public static final String MOD_ID = "venturer";
    public static final Logger logger = LogUtils.getLogger();

    public Venturer() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //Registries
        VenturerItems.register(eventBus);
        VenturerBlocks.register(eventBus);
        VenturerEntityTypes.register(eventBus);
        VenturerParticles.register(eventBus);
        VenturerPaintings.register(eventBus);
        VenturerSoundEvents.register(eventBus);
        VenturerEffects.register(eventBus);
        VenturerPotions.register(eventBus);
        ////////////////////////////////////////////
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
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
