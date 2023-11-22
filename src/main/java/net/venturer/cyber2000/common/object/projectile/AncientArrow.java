package net.venturer.cyber2000.common.object.projectile;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.venturer.cyber2000.core.registry.object.VenturerEntityTypes;
import net.venturer.cyber2000.core.registry.object.VenturerParticles;

public class AncientArrow extends AbstractArrow {
    public AncientArrow(EntityType<? extends AncientArrow> entityType, Level level) {
        super(entityType, level);
    }

    public AncientArrow(Level level, double pX, double pY, double pZ) {
        super(VenturerEntityTypes.ANCIENT_ARROW.get(), pX, pY, pZ, level);
    }

    public AncientArrow(Level level, LivingEntity shooter) {
        super(VenturerEntityTypes.ANCIENT_ARROW.get(), shooter, level);
    }

    @Override
    public void tick() {
        super.tick();
        Level level = this.level();
            if (level.isClientSide) {
                if (!this.inGround) this.makeParticle(5);
            } else if (this.inGround && this.inGroundTime != 0 && this.inGroundTime >= 600)
                level.broadcastEntityEvent(this, (byte) 0);
    }

    private void makeParticle(int particleAmount) {
        int i = 0x5d658f;
        if (particleAmount > 0) {
            double d0 = (double)(i >> 16 & 255) / 255.0D;
            double d1 = (double)(i >> 8 & 255) / 255.0D;
            double d2 = (double)(i & 255) / 255.0D;

            for(int j = 0; j < particleAmount * 5; ++j) {
                if ((j % 5) == 1) {
                    this.level().addParticle((ParticleOptions) VenturerParticles.ANCIENT_STAR.get(), this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), d0, d1, d2);
                }
            }
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.ARROW);
    }
}
