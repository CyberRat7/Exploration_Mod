package net.venturer.temporal.core.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.venturer.temporal.Venturer;
import net.venturer.temporal.common.object.entity.Coyote;
import net.venturer.temporal.core.registry.object.VenturerEntityTypes;

@Mod.EventBusSubscriber(modid = Venturer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VenturerEntityEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityAttributeCreationEvent event) {
        event.put(VenturerEntityTypes.COYOTE.get(), Coyote.createAttributes().build());
    }
}
