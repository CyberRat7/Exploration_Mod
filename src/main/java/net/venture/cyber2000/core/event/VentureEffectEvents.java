package net.venture.cyber2000.core.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.venture.cyber2000.Venture;
import net.venture.cyber2000.core.registry.object.VentureEffects;

@Mod.EventBusSubscriber(modid = Venture.MOD_ID)
public class VentureEffectEvents {
    @SubscribeEvent
    public static void applyEffects(MobEffectEvent.Applicable event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(VentureEffects.IMMUNITY.get())
                && !event.getEffectInstance().getEffect().equals(VentureEffects.IMMUNITY.get())) {
            event.setResult(Event.Result.DENY);
        }
    }
}
