package net.venture.cyber2000;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.venture.cyber2000.common.object.potion.VentureBrewingRecipe;
import net.venture.cyber2000.core.registry.object.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Venture.MOD_ID)
public class Venture {
    public static final String MOD_ID = "venture";
    public static final Logger logger = LogUtils.getLogger();

    public Venture() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //Registries
        VentureItems.register(eventBus);
        VentureBlocks.register(eventBus);
        VentureEntityTypes.register(eventBus);
        VentureParticles.register(eventBus);
        VenturePaintings.register(eventBus);
        VentureSoundEvents.register(eventBus);
        VentureEffects.register(eventBus);
        VenturePotions.register(eventBus);
        ////////////////////////////////////////////
        eventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VentureBlocks.STINGING_NETTLE.getId(), VentureBlocks.POTTED_STINGING_NETTLE);

            BrewingRecipeRegistry.addRecipe(new VentureBrewingRecipe(Potions.AWKWARD,
                    VentureItems.NETTLE_LEAVES.get(), VenturePotions.IMMUNITY_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new VentureBrewingRecipe(VenturePotions.IMMUNITY_POTION.get(),
                    Items.REDSTONE, VenturePotions.LONG_IMMUNITY_POTION.get()));
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        VentureCreativeTabs.register(event);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
