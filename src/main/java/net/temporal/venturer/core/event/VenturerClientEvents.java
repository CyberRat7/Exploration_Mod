package net.temporal.venturer.core.event;

import com.temporal.api.core.event.fov.BowFOVModifier;
import com.temporal.api.core.event.fov.FOVModifier;
import com.temporal.api.core.util.properties.TemporalItemProperties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.temporal.venturer.Venturer;
import net.temporal.venturer.client.model.CoyoteModel;
import net.temporal.venturer.client.renderer.AncientArrowRenderer;
import net.temporal.venturer.client.renderer.CoyoteRenderer;
import net.temporal.venturer.common.object.particle.AncientStarParticle;
import net.temporal.venturer.common.object.potion.VenturerBrewingRecipe;
import net.temporal.venturer.core.registry.object.*;

@Mod.EventBusSubscriber(modid = Venturer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VenturerClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            TemporalItemProperties temporalItemProperties = TemporalItemProperties.getInstance();
            temporalItemProperties.makeBow(VenturerItems.ANCIENT_BOW.get());

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VenturerBlocks.STINGING_NETTLE.getId(), VenturerBlocks.POTTED_STINGING_NETTLE);

        });
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(VenturerEntityTypes.ANCIENT_ARROW.get(), AncientArrowRenderer::new);
        event.registerEntityRenderer(VenturerEntityTypes.COYOTE.get(), CoyoteRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CoyoteModel.LAYER_LOCATION, CoyoteModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerParticleFactory(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(VenturerParticles.ANCIENT_STAR.get(), AncientStarParticle.Provider::new);
    }

    @SubscribeEvent
    public void computeFOVModifier(ComputeFovModifierEvent event) {
        FOVModifier bowFOVModifier = new BowFOVModifier();
        bowFOVModifier.modify(event, VenturerItems.ANCIENT_BOW.get());
    }
}
