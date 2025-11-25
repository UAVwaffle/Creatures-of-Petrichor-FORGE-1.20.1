package com.uavwaffle.creaturesofpetrichor.entity.custom;

import com.uavwaffle.creaturesofpetrichor.entity.custom.goal.PetrichorTameableHostileMeleeAttackGoal;
import com.uavwaffle.creaturesofpetrichor.entity.custom.type.PetrichorTameableHostileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class MeadowSlimeSmallEntity extends PetrichorTameableHostileEntity {

    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.meadow_slime_small.idle");
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.meadow_slime_small.walk");
    public static final RawAnimation ATTACK_ANIMATION = RawAnimation.begin().then("animation.meadow_slime_small.attack", Animation.LoopType.PLAY_ONCE);


    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public MeadowSlimeSmallEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, 16);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.18f);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(4, new PetrichorTameableHostileMeleeAttackGoal(this, 1.0d, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isTame));
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
        return 0.3f;
    }

    /* SOUNDS */
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SLIME_BLOCK_PLACE;
    }
    @Override
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.SLIME_HURT_SMALL;
    }
    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.SLIME_HURT_SMALL;
    }
    @Override
    protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
        this.playSound(SoundEvents.TUFF_BREAK, 0.001F, 0.01F);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NotNull ServerLevel pLevel, @NotNull AgeableMob pOtherParent) {
        return null;
    }
}
