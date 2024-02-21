package net.temporal.venturer.core.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.temporal.venturer.Venturer;
import net.temporal.venturer.common.object.entity.Coyote;
import net.temporal.venturer.core.registry.object.VenturerEntityTypes;

@Mod.EventBusSubscriber(modid = Venturer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VenturerEntityEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityAttributeCreationEvent event) {
        event.put(VenturerEntityTypes.COYOTE.get(), Coyote.createAttributes().build());
    }
}
