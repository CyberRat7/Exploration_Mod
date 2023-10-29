package net.venture.cyber2000.common.object.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.level.Level;

import java.util.Collection;

public class ImmunityEffect extends MobEffect {
    public ImmunityEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int pAmplifier) {
        Collection<MobEffectInstance> effects = livingEntity.getActiveEffects();
        effects.forEach(effectInstance -> {
            MobEffect effect = effectInstance.getEffect();
            if (!(effect instanceof ImmunityEffect)) {
                livingEntity.removeEffect(effect);
            }
        });
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
