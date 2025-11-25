package com.uavwaffle.creaturesofpetrichor.entity.custom;

import com.uavwaffle.creaturesofpetrichor.entity.custom.goal.PetrichorMeleeAttackGoal;
import com.uavwaffle.creaturesofpetrichor.entity.custom.type.PetrichorAttackingEntity;
import com.uavwaffle.creaturesofpetrichor.entity.varient_enum.ShroominVarient;
import com.uavwaffle.creaturesofpetrichor.util.id.ModLootTables;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class ShroominEntity extends PetrichorAttackingEntity {

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(ShroominEntity.class, EntityDataSerializers.INT);

    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.shroomin.idle");
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.shroomin.walk");
    public static final RawAnimation ATTACK_ANIMATION = RawAnimation.begin().then("animation.shroomin.attack", Animation.LoopType.PLAY_ONCE);


    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public ShroominEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, 13);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 14.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 30.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 30.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(4, new PetrichorMeleeAttackGoal(this, 1.0d, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }



        @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {


        controllers.add(new AnimationController<>(this, "Walk/Idle", 5, state -> state.setAndContinue(state.isMoving() ? WALK : IDLE)));
        controllers.add(new AnimationController<>(this, "AttackController", state -> PlayState.STOP).triggerableAnim("Attack", ATTACK_ANIMATION));

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    protected float getStandingEyeHeight(@NotNull Pose pPose, @NotNull EntityDimensions pSize) {
        return 1.0f;
    }



    /* VARIANT STUFF */
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public ShroominVarient getVariant() {
        return ShroominVarient.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(ShroominVarient variant) {
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
        ShroominVarient variant = Util.getRandom(ShroominVarient.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    public @NotNull ResourceLocation getDefaultLootTable() {
        return switch (this.getTypeVariant()) {
            case 0 -> ModLootTables.SHROOMIN_RED;
            case 1 -> ModLootTables.SHROOMIN_BROWN;
            default -> throw new IncompatibleClassChangeError();
        };
    }


        /* SOUNDS */
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COMPOSTER_READY;
    }
    @Override
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.NYLIUM_BREAK;
    }
    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.NYLIUM_BREAK;
    }
    @Override
    protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
        this.playSound(SoundEvents.BIG_DRIPLEAF_PLACE, 0.15F, 1.0F);
    }
}
