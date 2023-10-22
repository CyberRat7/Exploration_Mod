package net.explorationmod.cyber2000;

import com.mojang.logging.LogUtils;
import net.explorationmod.cyber2000.core.registry.object.VentureItems;
import net.explorationmod.cyber2000.core.registry.object.VenturePaintings;
import net.explorationmod.cyber2000.core.registry.object.VentureSoundEvents;
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
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //Registries
        VentureItems.register(modEventBus);
        VenturePaintings.register(modEventBus);
        VentureSoundEvents.register(modEventBus);
        ////////////////////////////////////////////
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
