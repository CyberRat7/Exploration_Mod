package net.venturer.cyber2000;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.venturer.cyber2000.common.object.potion.*;
import net.venturer.cyber2000.core.registry.object.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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
        eventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VenturerBlocks.STINGING_NETTLE.getId(), VenturerBlocks.POTTED_STINGING_NETTLE);
//            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VenturerBlocks.ORANGE_MARIGOLD.getId(), VenturerBlocks.POTTED_ORANGE_MARIGOLD);
//            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VenturerBlocks.YELLOW_MARIGOLD.getId(), VenturerBlocks.POTTED_YELLOW_MARIGOLD);

            BrewingRecipeRegistry.addRecipe(new VenturerBrewingRecipe(Potions.AWKWARD,
                    VenturerItems.NETTLE_LEAVES.get(), VenturerPotions.IMMUNITY_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new VenturerBrewingRecipe(VenturerPotions.IMMUNITY_POTION.get(),
                    Items.REDSTONE, VenturerPotions.LONG_IMMUNITY_POTION.get()));

            PotionBrewing.addMix(Potions.AWKWARD, VenturerItems.NETTLE_LEAVES.get(), VenturerPotions.IMMUNITY_POTION.get());
            PotionBrewing.addMix(VenturerPotions.IMMUNITY_POTION.get(), Items.REDSTONE, VenturerPotions.LONG_IMMUNITY_POTION.get());

            ComposterBlock.COMPOSTABLES.put(VenturerItems.NETTLE_LEAVES.get(), 0.30f);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        VenturerCreativeTabs.register(event);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
