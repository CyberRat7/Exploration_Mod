package net.temporal.venturer.core.event;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.temporal.venturer.Venturer;
import net.temporal.venturer.client.model.CoyoteModel;
import net.temporal.venturer.common.object.entity.Coyote;
import net.temporal.venturer.core.registry.object.VenturerEntityTypes;

@Mod.EventBusSubscriber(modid = Venturer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VenturerCommonModBusEvents {
	
	// jason: not sure if these should be client-side only as in VenturerClientEvents and VenturerEntityEvents
	// @SubscribeEvent
	// public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
	// 	event.registerLayerDefinition(CoyoteModel.LAYER_LOCATION, CoyoteModel::createBodyLayer);
	// }
	//
	// @SubscribeEvent
	// public static void registerRenderers(EntityAttributeCreationEvent event) {
	// 	event.put(VenturerEntityTypes.COYOTE.get(), Coyote.createAttributes().build());
	// }
	
	// @SubscribeEvent
	// public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
	// 	event.register(VenturerEntityTypes.COYOTE.get(),
	// 		SpawnPlacements.Type.ON_GROUND,
	// 		Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
	// 		Animal::checkAnimalSpawnRules,
	// 		SpawnPlacementRegisterEvent.Operation.REPLACE);
	// }
}
