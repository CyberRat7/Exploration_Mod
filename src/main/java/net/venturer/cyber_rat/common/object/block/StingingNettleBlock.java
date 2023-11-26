package net.venturer.cyber_rat.common.object.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.venturer.cyber_rat.core.registry.object.VenturerEffects;

@SuppressWarnings("ALL")
public class StingingNettleBlock extends FlowerBlock {
    public StingingNettleBlock(Properties blockProperties) {
        super(VenturerEffects.IMMUNITY, 6, blockProperties);

    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.makeStuckInBlock(blockState, new Vec3((double)0.8F, 0.75D, (double)0.8F));
            if (!level.isClientSide && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                double d0 = Math.abs(entity.getX() - entity.xOld);
                double d1 = Math.abs(entity.getZ() - entity.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    entity.hurt(level.damageSources().sweetBerryBush(), 1.0F);
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(VenturerEffects.IMMUNITY.get(), 100));
                }
            }
        }
    }
}
