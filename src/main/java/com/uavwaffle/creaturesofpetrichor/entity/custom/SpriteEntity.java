package com.uavwaffle.creaturesofpetrichor.entity.custom;

import com.uavwaffle.creaturesofpetrichor.entity.varient_enum.SpriteVarient;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class SpriteEntity extends PathfinderMob implements GeoEntity {

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(SpriteEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> SPRINTING_DATA =
            SynchedEntityData.defineId(SpriteEntity.class, EntityDataSerializers.BOOLEAN);


    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.sprite.idle");
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.sprite.walk");
    public static final RawAnimation RUN = RawAnimation.begin().thenLoop("animation.sprite.run");



    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public SpriteEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return AmbientCreature.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.20f);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 5.0f, 2.5D,2.5D));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.5D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 16.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (level().isClientSide()) {
            return;
        }
        setPanickingData();

    }


    private boolean shouldSprintServerSide() {
        boolean panicking = goalSelector.getRunningGoals().anyMatch(prioritizedGoal -> prioritizedGoal.getGoal().getClass() == PanicGoal.class);
        boolean running = goalSelector.getRunningGoals().anyMatch(prioritizedGoal -> prioritizedGoal.getGoal().getClass() == AvoidEntityGoal.class);
        return panicking || running;
    }



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

            controllers.add( new AnimationController<>(this, "Walk/Idle", 10, state -> { //feature preview for resting transitions
                if (entityData.get(SPRINTING_DATA)) {
                    return state.setAndContinue(RUN);
                }
                if (state.isMoving()) {
                    return state.setAndContinue(WALK);
                }
                return state.setAndContinue(IDLE);
            }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    protected float getStandingEyeHeight(@NotNull Pose pPose, @NotNull EntityDimensions pSize) {
        return 0.5f;
    }

    /* VARIANT STUFF (and entity sync data) */
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(VARIANT, 0);
        entityData.define(SPRINTING_DATA, false);
    }

    private void setPanickingData() {
        if (shouldSprintServerSide()) {
            entityData.set(SPRINTING_DATA, true);
            return;
        }
        entityData.set(SPRINTING_DATA, false);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public SpriteVarient getVariant() {
        return SpriteVarient.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(SpriteVarient variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(VARIANT, pCompound.getInt("Variant"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor pLevel, @NotNull DifficultyInstance pDifficulty, @NotNull MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        SpriteVarient variant = Util.getRandom(SpriteVarient.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }


    /* SOUNDS */
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.AZALEA_LEAVES_PLACE;
    }
    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.AZALEA_LEAVES_BREAK;
    }
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.AZALEA_LEAVES_BREAK;
    }
    @Override
    protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
        this.playSound(SoundEvents.BIG_DRIPLEAF_PLACE, 0.15F, 1.0F);
    }

}
