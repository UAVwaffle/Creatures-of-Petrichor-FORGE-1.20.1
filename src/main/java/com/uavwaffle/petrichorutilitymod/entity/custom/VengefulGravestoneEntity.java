package com.uavwaffle.petrichorutilitymod.entity.custom;

import com.uavwaffle.petrichorutilitymod.entity.custom.goal.PetrichorMeleeAttackGoal;
import com.uavwaffle.petrichorutilitymod.entity.custom.type.PetrichorNoFallEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class VengefulGravestoneEntity extends PetrichorNoFallEntity {

//    private boolean resting = true;

    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.vengeful_gravestone_entity.idle");
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.vengeful_gravestone_entity.walk");
    public static final RawAnimation ATTACK_ANIMATION = RawAnimation.begin().then("animation.vengeful_gravestone_entity.attack", Animation.LoopType.PLAY_ONCE);
//    public static final RawAnimation REST = RawAnimation.begin().thenLoop("animation.vengeful_gravestone_entity.rest");
//    public static final RawAnimation RESTING = RawAnimation.begin().thenLoop("animation.vengeful_gravestone_entity.resting");
//    public static final RawAnimation AWAKEN = RawAnimation.begin().thenLoop("animation.vengeful_gravestone_entity.awaken");


    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public VengefulGravestoneEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, 13);
        this.setMaxUpStep(1.0F);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(4, new PetrichorMeleeAttackGoal(this, 1.0d, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BoulderSpiritEntity.class, true));
    }

    @Override
    protected int decreaseAirSupply(int pAir) {
        return pAir;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {


        controllers.add(new AnimationController<>(this, "Walk/Idle", 5, state -> state.setAndContinue(state.isMoving() ? WALK : IDLE)));

//            controllers.add( new AnimationController<>(this, "Walk/Idle", 10, state -> { //feature preview for resting transitions
//            if (state.isMoving()) {
//                resting = false;
//                return state.setAndContinue(WALK);
//            }
//            if (resting) {
//                return state.setAndContinue(RESTING);
//            }
//            return state.setAndContinue(IDLE);
//
//            }));

        controllers.add(new AnimationController<>(this, "AttackController", state -> PlayState.STOP).triggerableAnim("Attack", ATTACK_ANIMATION));

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    protected float getStandingEyeHeight(@NotNull Pose pPose, @NotNull EntityDimensions pSize) {
        return 2.2f;
    }

    /* SOUNDS */
    @Override
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.DEEPSLATE_BREAK;
    }
    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.ANCIENT_DEBRIS_BREAK;
    }
    @Override
    protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
        this.playSound(SoundEvents.TUFF_BREAK, 0.3F, 0.75F);
    }


}
