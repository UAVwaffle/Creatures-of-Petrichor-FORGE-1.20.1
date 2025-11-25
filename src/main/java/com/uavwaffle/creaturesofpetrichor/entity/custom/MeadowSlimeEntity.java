package com.uavwaffle.creaturesofpetrichor.entity.custom;

import com.uavwaffle.creaturesofpetrichor.entity.custom.goal.PetrichorTameableHostileMeleeAttackGoal;
import com.uavwaffle.creaturesofpetrichor.entity.custom.type.PetrichorTameableHostileEntity;
import com.uavwaffle.creaturesofpetrichor.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Objects;
import java.util.function.Predicate;

public class MeadowSlimeEntity extends PetrichorTameableHostileEntity implements Bucketable {

    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(MeadowSlimeEntity.class, EntityDataSerializers.BOOLEAN);

    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.meadow_slime.idle");
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.meadow_slime.walk");
    public static final RawAnimation ATTACK_ANIMATION = RawAnimation.begin().then("animation.meadow_slime.attack", Animation.LoopType.PLAY_ONCE);

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public MeadowSlimeEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, 16);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(4, new PetrichorTameableHostileMeleeAttackGoal(this, 1.0d, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, Predicate.not(this::isTame)));
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

        controllers.add(new AnimationController<>(this, "Walk/Idle", 5, state -> state.setAndContinue(state.isMoving() ? WALK : IDLE)));
        controllers.add(new AnimationController<>(this, "AttackController", state -> PlayState.STOP).triggerableAnim("Attack", ATTACK_ANIMATION));

    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    protected float getStandingEyeHeight(@NotNull Pose pPose, @NotNull EntityDimensions pSize) {
        return 0.4f;
    }

    public @NotNull InteractionResult mobInteract(Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (this.level().isClientSide) {
            boolean flag = this.isOwnedBy(pPlayer) || this.isTame() || itemstack.is(Items.CORNFLOWER) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        }

        if (this.isTame()) {
            if (itemstack.is(Items.WATER_BUCKET)) {
                return Bucketable.bucketMobPickup(pPlayer, pHand, this).orElse(super.mobInteract(pPlayer, pHand));
            }else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                this.heal(2);
                if (!pPlayer.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
            InteractionResult interactionresult = super.mobInteract(pPlayer, pHand);
            if ((!interactionresult.consumesAction())) {
                this.setOrderedToSit(!this.isOrderedToSit());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget(null);
                return InteractionResult.SUCCESS;
            } else {
                return interactionresult;
            }
        } else if (itemstack.is(Items.CORNFLOWER)) {
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                this.tame(pPlayer);
                this.navigation.stop();
                this.setTarget(null);
                this.setOrderedToSit(true);
                this.level().broadcastEntityEvent(this, (byte)7);
            } else {
                this.level().broadcastEntityEvent(this, (byte)6);
            }

            return InteractionResult.SUCCESS;
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.CORNFLOWER);
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean pFromBucket) {
        this.entityData.set(FROM_BUCKET, pFromBucket);
    }

    public void saveToBucketTag(@NotNull ItemStack pStack) {
        Bucketable.saveDefaultDataToBucketTag(this, pStack);
        CompoundTag compoundtag = pStack.getOrCreateTag();
        compoundtag.putUUID("Owner", Objects.requireNonNull(getOwnerUUID()));
        compoundtag.putInt("Age", this.getAge());
    }

    public void loadFromBucketTag(@NotNull CompoundTag pTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, pTag);
        if (pTag.contains("Owner")) {
            this.setTame(true);
            this.setOwnerUUID(pTag.getUUID("Owner"));
        }
        if (pTag.contains("Age")) {
            this.setAge(pTag.getInt("Age"));
        }
    }

    public @NotNull ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.MEADOW_SLIME_BUCKET.get());
    }


    public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("FromBucket", this.fromBucket());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setFromBucket(pCompound.getBoolean("FromBucket"));
    }

    public @NotNull SoundEvent getPickupSound() {
        return SoundEvents.SLIME_BLOCK_PLACE;
    }
    //    public void remove(Entity.@NotNull RemovalReason reason) { //make more entities
//        if (!this.level().isClientSide && this.isDeadOrDying()) {
//            Component component = this.getCustomName();
//            boolean flag = this.isNoAi();

    /// /            int k = this.random.nextInt(2) + 1;
//
//            for(int l = 0; l < 2; ++l) {
//                MeadowSlimeSmallEntity smallMeadowSlime = ModEntities.MEADOW_SLIME_SMALL.get().create(level());
//                if (smallMeadowSlime != null) {
//                    if (this.isPersistenceRequired()) {
//                        smallMeadowSlime.setPersistenceRequired();
//                    }
//
//                    smallMeadowSlime.setCustomName(component);
//                    smallMeadowSlime.setNoAi(flag);
//                    smallMeadowSlime.setInvulnerable(this.isInvulnerable());
//                    smallMeadowSlime.moveTo(this.getX(), this.getY() + 0.5D, this.getZ(), this.random.nextFloat() * 360.0F, 0.0F);
//                    this.level().addFreshEntity(smallMeadowSlime);
//                }
//            }
//        }
//
//        super.remove(reason);
//    }

    /* SOUNDS */
    public void playAmbientSound() {
        this.playSound(SoundEvents.SLIME_BLOCK_PLACE, 0.50F, 1.0F);
    }

    @Override
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.SLIME_HURT;
    }

    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.SLIME_DEATH;
    }

    @Override
    protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
        this.playSound(SoundEvents.SLIME_BLOCK_PLACE, 0.50F, 0.25F);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NotNull ServerLevel pLevel, @NotNull AgeableMob pOtherParent) {
        return null;
    }
}
