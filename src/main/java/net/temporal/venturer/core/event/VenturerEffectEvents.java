package net.temporal.venturer.core.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.temporal.venturer.Venturer;
import net.temporal.venturer.core.registry.object.VenturerEffects;

@Mod.EventBusSubscriber(modid = Venturer.MOD_ID)
public class VenturerEffectEvents {
    @SubscribeEvent
    public static void applyEffects(MobEffectEvent.Applicable event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(VenturerEffects.IMMUNITY.get())
                && !event.getEffectInstance().getEffect().equals(VenturerEffects.IMMUNITY.get())) {
            event.setResult(Event.Result.DENY);
        }
    }
}
