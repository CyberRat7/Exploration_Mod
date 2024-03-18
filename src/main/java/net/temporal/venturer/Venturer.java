package net.temporal.venturer;

import com.mojang.logging.LogUtils;
import com.temporal.api.core.engine.TemporalEngine;
import com.temporal.api.core.event.tab.SimpleTabAdder;
import com.temporal.api.core.util.properties.TemporalItemProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.temporal.venturer.common.object.potion.VenturerBrewingRecipe;
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
    public static final Logger LOGGER = LogUtils.getLogger();

    public Venturer() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        TemporalEngine.process(Venturer.class);
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
        eventBus.addListener(this::commonSetup);
    }



    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            TemporalItemProperties temporalItemProperties = TemporalItemProperties.getInstance();
            temporalItemProperties.putCompostable(VenturerBlocks.STINGING_NETTLE.get().asItem(), 0.65f);
            temporalItemProperties.putCompostable(VenturerItems.NETTLE_LEAVES.get().asItem(), 0.45f);

            BrewingRecipeRegistry.addRecipe(new VenturerBrewingRecipe(Potions.AWKWARD,
                    VenturerItems.NETTLE_LEAVES.get(), VenturerPotions.IMMUNITY_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new VenturerBrewingRecipe(VenturerPotions.IMMUNITY_POTION.get(),
                    Items.REDSTONE, VenturerPotions.LONG_IMMUNITY_POTION.get()));

            PotionBrewing.addMix(Potions.AWKWARD, VenturerItems.NETTLE_LEAVES.get(), VenturerPotions.IMMUNITY_POTION.get());
            PotionBrewing.addMix(VenturerPotions.IMMUNITY_POTION.get(), Items.REDSTONE, VenturerPotions.LONG_IMMUNITY_POTION.get());
        });
    }

    @SuppressWarnings("unchecked")
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        new SimpleTabAdder(event)
                .addAllToTab(CreativeModeTabs.INGREDIENTS,
                         VenturerItems.NETTLE_LEAVES,
                        VenturerItems.CHILL_ARMOR_TRIM_SMITHING_TEMPLATE)
                .addAllToTab(CreativeModeTabs.TOOLS_AND_UTILITIES, VenturerItems.MUSIC_DISC_THAW)
                .addAllToTab(CreativeModeTabs.FOOD_AND_DRINKS, VenturerItems.NETTLE_SOUP)
                .addAllToTab(CreativeModeTabs.NATURAL_BLOCKS, VenturerBlocks.STINGING_NETTLE,  VenturerBlocks.JUNIPER_ROOTS, VenturerBlocks.RED_SANDY_JUNIPER_ROOTS, VenturerBlocks.JUNIPER_LOG, VenturerBlocks.JUNIPER_LEAVES, VenturerBlocks.FLOWERING_JUNIPER_LEAVES)
                .addAllToTab(CreativeModeTabs.NATURAL_BLOCKS, VenturerBlocks.BAG_OF_NETTLE_LEAVES)
                .addAllToTab(CreativeModeTabs.BUILDING_BLOCKS, VenturerBlocks.JUNIPER_PLANKS, VenturerBlocks.JUNIPER_DOOR, VenturerBlocks.JUNIPER_TRAPDOOR, VenturerBlocks.JUNIPER_BUTTON, VenturerBlocks.JUNIPER_SLAB, VenturerBlocks.JUNIPER_STAIRS, VenturerBlocks.JUNIPER_FENCE, VenturerBlocks.JUNIPER_FENCE_GATE, VenturerBlocks.JUNIPER_PRESSURE_PLATE, VenturerBlocks.STRIPPED_JUNIPER_LOG, VenturerBlocks.JUNIPER_WOOD, VenturerBlocks.STRIPPED_JUNIPER_WOOD);


    }
}
