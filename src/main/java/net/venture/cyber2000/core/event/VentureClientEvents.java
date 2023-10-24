package net.venture.cyber2000.core.event;

import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.client.renderer.AncientArrowRenderer;
import net.venture.cyber2000.common.object.particle.AncientStarParticle;
import net.venture.cyber2000.core.registry.object.VentureEntityTypes;
import net.venture.cyber2000.core.registry.object.VentureItems;
import net.venture.cyber2000.core.registry.object.VentureParticles;
import net.venture.cyber2000.core.util.properties.CustomItemProperties;

@Mod.EventBusSubscriber(modid = Venture.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VentureClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(VentureEntityTypes.ANCIENT_ARROW.get(), AncientArrowRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        CustomItemProperties.addCustomItemProperties();
    }

    @SubscribeEvent
    public static void registerParticleFactory(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(VentureParticles.ANCIENT_STAR.get(), AncientStarParticle.Provider::new);
    }

    @SubscribeEvent
    public void bowFOVModifier(ComputeFovModifierEvent event) {
        if (isBowItem(event)) {
            float fov = event.getPlayer().getTicksUsingItem() / 20.0F;
            if (fov > 1.0F) fov = 1.0F;
            else fov *= fov;
            event.setNewFovModifier(event.getFovModifier() * (1.0F - (fov * 0.15F)));
        }
    }

    private boolean isBowItem(ComputeFovModifierEvent event) {
        return checkUsingItem(event, VentureItems.ANCIENT_BOW.get());
    }

    private boolean checkUsingItem(ComputeFovModifierEvent event, Item item) {
        return event.getPlayer().getUseItem().is(item) && event.getPlayer().isUsingItem();
    }
}
