package net.temporal.venturer.common.object.entity;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.temporal.venturer.core.registry.object.VenturerEntityTypes;
import net.temporal.venturer.core.tags.VenturerTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

/*

Coyotes:

Spawns in groups of: 1-3

Spawns in Biomes: Badlands, Wooded Badlands, Eroded Badlands

Health Points: 14

Attack Strength: Easy 4, Normal 5, Hard 7

Can be Bred: False

Drops: 1-3 Experience Orbs

Can be Leashed: True

Behavior / longform goals by Cyber Rat:

Coyotes are a neutral mob and will attack the player when provoked,

DONE - when a coyote turns aggressive towards a player all other coyotes nearby will start attacking the player similar to wolves or zombie piglins.
DONE - If a coyote detects a player with food in their hand or offhand the coyote will instantly turn aggressive towards that player.
DONE - If a coyote detects a zombie, husk or drowned nearby it will turn hostile towards the mob and attempt to kill the mob.
DONE - If a coyote detects a chicken, rabbit or goat nearby the coyote will also attempt to kill those mobs as well.

Zombies, Husks and Drowned will additionally avoid coyotes similar to how skeletons and strays avoid wolves and creepers avoid cats.
    this.goalSelector.addGoal(3, new AvoidEntityGoal(this, Wolf.class, 6.0F, 1.0, 1.2));

If a coyote notices rotten flesh or an item that falls into "forge:meats" on the ground nearby to it the coyote will stop what ever it is doing (attacking a player or mob) and go to eat the food. The coyote will pick up the food like a fox in its mouth and then consume it restoring 3 points of health to the coyote.

When a coyote at full health eats food on the ground it will get the hearts particle effect and breed with another coyote who does this. Coyotes cannot be bred by hand and can only be bred through this method. And there is a 500s breeding cooldown on this.

Baby coyotes can spawn as well, about as rarely as baby wolves.

After a coyote succesfully kills an entity they will have a 40% chance to do a shake animation when they perform this animation 1-2 coyote fur will drop on the ground.

Coyotes can't be damaged by blocks in a new tag called "prickly blocks" (put sweet berry bushes and cactus in this tag)


shortform goals by Jason13
coyotes spawn on any difficulty like wolves (implements NeutralMob)
coyotes alert others to being attacked and swarm on the attacker (HurtByTargetGoal)
coyotes attack players holding food items (this::checkMeatInPlayerHandOrNearby)
coyotes attack nearby zombies, husks, drowned, chicken, rabbits, and goats (NearestAttackableTargetGoal)

zombies/husks/drowned should avoid coyotes




*/

public class Coyote extends Animal implements NeutralMob {
    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(Coyote.class, EntityDataSerializers.INT);
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(5, 20);
    
    
    private static final Predicate<? super ItemEntity> ALLOWED_ITEMS = (itemEntity -> {
        ItemStack item = itemEntity.getItem();
        return item.is(Items.ROTTEN_FLESH) || item.getTags().anyMatch(Predicate.isEqual(VenturerTags.Items.MEATS));
    });
    
    
    @Nullable
    private UUID persistentAngerTarget;

    public Coyote(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new SearchForFoodGoal());
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        
        this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
        
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
        
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, false, false, this::isAngryAt));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Player.class, 10, false, false, this::checkMeatInPlayerHandOrNearby));
        
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Zombie.class, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Husk.class, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Drowned.class, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Chicken.class, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Rabbit.class, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Goat.class, false));
        this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));
    }
    
    @Override
    public boolean isAngryAt(@NotNull LivingEntity pTarget) {
        if (!this.canAttack(pTarget)) {
            return false;
        } else {
            
            for (ItemEntity entity : Coyote.this.level().getEntitiesOfClass(ItemEntity.class, Coyote.this.getBoundingBox().inflate(4.0D))) {
                ItemStack stack = entity.getItem();
                if (isFood(stack) || stack.is(Items.ROTTEN_FLESH)) {
                    Coyote.this.setLastHurtByMob((LivingEntity)null);
                    Coyote.this.setPersistentAngerTarget((UUID)null);
                    Coyote.this.setTarget((LivingEntity)null);
                    Coyote.this.setRemainingPersistentAngerTime(0);
                }
            }
            
            return pTarget.getType() == EntityType.PLAYER && this.isAngryAtAllPlayers(pTarget.level()) ? true : pTarget.getUUID().equals(this.getPersistentAngerTarget());
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.MAX_HEALTH, 7.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.addPersistentAngerSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readPersistentAngerSaveData(this.level(), compound);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getEntity();
            if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.hurt(source, amount);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean flag = entity.hurt(this.damageSources().mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, entity);
        }

        return flag;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean canEatFood = itemstack.getFoodProperties(this).isMeat();
        if (this.level().isClientSide) {
            return canEatFood ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else if (canEatFood) {
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            this.level().broadcastEntityEvent(this, (byte)6);
            return InteractionResult.SUCCESS;
        } else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 45) {
            ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (!itemstack.isEmpty()) {
                for(int i = 0; i < 8; ++i) {
                    Vec3 vec3 = (new Vec3(((double)this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).xRot(-this.getXRot() * ((float)Math.PI / 180F)).yRot(-this.getYRot() * ((float)Math.PI / 180F));
                    this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemstack), this.getX() + this.getLookAngle().x / 2.0D, this.getY(), this.getZ() + this.getLookAngle().z / 2.0D, vec3.x, vec3.y + 0.05D, vec3.z);
                }
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        Item item = itemStack.getItem();
        return item.isEdible() && itemStack.getFoodProperties(this).isMeat();
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        // TODO: 02.12.2023
        return VenturerEntityTypes.COYOTE.get().create(level);
    }
    

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.entityData.get(DATA_REMAINING_ANGER_TIME);
    }

    @Override
    public void setRemainingPersistentAngerTime(int remainingPersistentAngerTime) {
        this.entityData.set(DATA_REMAINING_ANGER_TIME, remainingPersistentAngerTime);
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID persistentAngerTarget) {
        this.persistentAngerTarget = persistentAngerTarget;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    public void tick() {
        super.tick();
        if (this.isAlive()) {
            AttributeInstance movementSpeed = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (this.isAngry()) {
                float spedUpValue = 1.2F;
                movementSpeed.setBaseValue(spedUpValue);
            } else {
                float baseValue = 0.3F;
                movementSpeed.setBaseValue(baseValue);
            }
        }
    }
    
    public boolean checkMeatInPlayerHandOrNearby(LivingEntity pTarget) {
        ItemStack main = pTarget.getMainHandItem();
        ItemStack off = pTarget.getOffhandItem();
        
        // for (ItemEntity entity : Coyote.this.level().getEntitiesOfClass(ItemEntity.class, Coyote.this.getBoundingBox().inflate(2.0D))) {
        //     ItemStack stack = entity.getItem();
        //     if (isFood(stack) || stack.is(Items.ROTTEN_FLESH)) {
        //         Coyote.this.forgetCurrentTargetAndRefreshUniversalAnger();
        //         return false;
        //     }
        // }
        
        return (!main.isEmpty() || !off.isEmpty()) && (main.is(VenturerTags.Items.EDIBLE) || off.is(VenturerTags.Items.EDIBLE));
    }
    
    class SearchForFoodGoal extends Goal {
        public SearchForFoodGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if (!Coyote.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
                return false;
            } else if (Coyote.this.getTarget() == null && Coyote.this.getLastHurtByMob() == null) {
                if (Coyote.this.getRandom().nextInt(reducedTickDelay(10)) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = Coyote.this.level().getEntitiesOfClass(ItemEntity.class, Coyote.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), ALLOWED_ITEMS);
                    return !list.isEmpty() && Coyote.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void tick() {
            List<ItemEntity> list = Coyote.this.level().getEntitiesOfClass(ItemEntity.class, Coyote.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), ALLOWED_ITEMS);
            ItemStack itemstack = Coyote.this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (itemstack.isEmpty() && !list.isEmpty()) {
                Coyote.this.getNavigation().moveTo(list.get(0), 1.2F);
            }

            List<ItemEntity> items = Coyote.this.level().getEntitiesOfClass(ItemEntity.class, Coyote.this.getBoundingBox().inflate(0.5D, 0.5D, 0.5D), ALLOWED_ITEMS);
            ItemEntity itemToEat = null;
            if (!items.isEmpty()) itemToEat = items.get(0);
            if (itemToEat != null) {
                Coyote.this.pickUpItem(itemToEat);
                boolean canEat = Coyote.this.onGround() && Coyote.this.getTarget() == null && Coyote.this.getLastHurtByMob() == null;
                if (canEat) {
                    
                    // Coyote.this.setRemainingPersistentAngerTime(0);
                    // Coyote.this.setInLoveTime(10);
                    
                    ItemStack item = itemToEat.getItem();
                    Coyote.this.eat(Coyote.this.level(), item);
                    SoundEvent eatingSound = Coyote.this.getEatingSound(item);
                    Coyote.this.playSound(eatingSound);
                    if (Coyote.this.getHealth() != Coyote.this.getAttribute(Attributes.MAX_HEALTH).getValue()) Coyote.this.setHealth(Coyote.this.getHealth() + 1);
                    Coyote.this.removeEffect(MobEffects.HUNGER);
                    Coyote.this.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
                }
            }
        }

        @Override
        public void start() {
            List<ItemEntity> list = Coyote.this.level().getEntitiesOfClass(ItemEntity.class, Coyote.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), ALLOWED_ITEMS);
            if (!list.isEmpty()) {
                Coyote.this.getNavigation().moveTo(list.get(0), 1.2F);
            }
        }
    }
    
    @Override
    public boolean checkSpawnRules(LevelAccessor pLevel, MobSpawnType pSpawnReason) {
        return true;
    }
    
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
    
    @Override
    public boolean canBreed() {
        return true;
    }
}
