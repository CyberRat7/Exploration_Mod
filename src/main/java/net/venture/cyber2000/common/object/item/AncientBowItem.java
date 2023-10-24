package net.venture.cyber2000.common.object.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.venture.cyber2000.core.registry.object.VentureItems;

public class AncientBowItem extends BowItem {
    public static final int DEFAULT_RANGE = 18;

    public AncientBowItem(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || stack.getEnchantmentLevel(Enchantments.INFINITY_ARROWS) > 0;
            ItemStack itemstack = player.getProjectile(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, level, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, player));
                    if (!level.isClientSide) {
                        ArrowItem arrowItem = (AncientArrowItem) (itemstack.getItem() instanceof AncientArrowItem ? itemstack.getItem() : VentureItems.ANCIENT_ARROW.get());
                        AbstractArrow abstractarrow = arrowItem.createArrow(level, itemstack, player);
                        abstractarrow = customArrow(abstractarrow);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 5.0F, 1.0F);

                        if (f == 1.0F) abstractarrow.setCritArrow(true);

                        int j = stack.getEnchantmentLevel(Enchantments.POWER_ARROWS);
                        if (j > 0) abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);

                        int k = stack.getEnchantmentLevel(Enchantments.PUNCH_ARROWS);
                        if (k > 0) abstractarrow.setKnockback(k);

                        if (stack.getEnchantmentLevel(Enchantments.FLAMING_ARROWS) > 0) abstractarrow.setSecondsOnFire(100);

                        stack.hurtAndBreak(1, player, (onBroken) -> {
                            onBroken.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW)))
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        level.addFreshEntity(abstractarrow);
                    }

                    level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) player.getInventory().removeItem(itemstack);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public int getDefaultProjectileRange() {
        return DEFAULT_RANGE;
    }
}