package net.venturer.temporal.core.event;

import com.temporal.api.core.event.fov.BowFOVModifier;
import com.temporal.api.core.event.fov.FOVModifier;
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
import net.venturer.temporal.Venturer;
import net.venturer.temporal.client.model.CoyoteModel;
import net.venturer.temporal.client.renderer.AncientArrowRenderer;
import net.venturer.temporal.client.renderer.CoyoteRenderer;
import net.venturer.temporal.common.object.particle.AncientStarParticle;
import net.venturer.temporal.common.object.potion.VenturerBrewingRecipe;
import net.venturer.temporal.core.registry.object.*;
import net.venturer.temporal.core.util.properties.CustomItemProperties;

@Mod.EventBusSubscriber(modid = Venturer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VenturerClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            CustomItemProperties.addCustomItemProperties();

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(VenturerBlocks.STINGING_NETTLE.getId(), VenturerBlocks.POTTED_STINGING_NETTLE);

            BrewingRecipeRegistry.addRecipe(new VenturerBrewingRecipe(Potions.AWKWARD,
                    VenturerItems.NETTLE_LEAVES.get(), VenturerPotions.IMMUNITY_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new VenturerBrewingRecipe(VenturerPotions.IMMUNITY_POTION.get(),
                    Items.REDSTONE, VenturerPotions.LONG_IMMUNITY_POTION.get()));

            PotionBrewing.addMix(Potions.AWKWARD, VenturerItems.NETTLE_LEAVES.get(), VenturerPotions.IMMUNITY_POTION.get());
            PotionBrewing.addMix(VenturerPotions.IMMUNITY_POTION.get(), Items.REDSTONE, VenturerPotions.LONG_IMMUNITY_POTION.get());
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
    public void FOVModifier(ComputeFovModifierEvent event) {
        FOVModifier bowFOVModifier = new BowFOVModifier();
        bowFOVModifier.modify(event, VenturerItems.ANCIENT_BOW.get());
    }
}
