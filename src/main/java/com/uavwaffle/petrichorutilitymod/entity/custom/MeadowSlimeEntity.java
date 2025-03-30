package com.uavwaffle.petrichorutilitymod.entity.custom;

import com.uavwaffle.petrichorutilitymod.entity.ModEntities;
import com.uavwaffle.petrichorutilitymod.entity.custom.goal.PetrichorMeleeAttackGoal;
import com.uavwaffle.petrichorutilitymod.entity.custom.type.PetrichorAttackingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
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

public class MeadowSlimeEntity extends PetrichorAttackingEntity {

    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.meadow_slime.idle");
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.meadow_slime.walk");
    public static final RawAnimation ATTACK_ANIMATION = RawAnimation.begin().then("animation.meadow_slime.attack", Animation.LoopType.PLAY_ONCE);

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public MeadowSlimeEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, 16);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(4, new PetrichorMeleeAttackGoal(this, 1.0d, false));
//        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.3F));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BoulderSpiritEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
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
        return 0.4f;
    }

    public void remove(Entity.@NotNull RemovalReason reason) { //make more entities
        if (!this.level().isClientSide && this.isDeadOrDying()) {
            Component component = this.getCustomName();
            boolean flag = this.isNoAi();
//            int k = this.random.nextInt(2) + 1;

            for(int l = 0; l < 2; ++l) {
                MeadowSlimeSmallEntity smallMeadowSlime = ModEntities.MEADOW_SLIME_SMALL.get().create(level());
                if (smallMeadowSlime != null) {
                    if (this.isPersistenceRequired()) {
                        smallMeadowSlime.setPersistenceRequired();
                    }

                    smallMeadowSlime.setCustomName(component);
                    smallMeadowSlime.setNoAi(flag);
                    smallMeadowSlime.setInvulnerable(this.isInvulnerable());
                    smallMeadowSlime.moveTo(this.getX(), this.getY() + 0.5D, this.getZ(), this.random.nextFloat() * 360.0F, 0.0F);
                    this.level().addFreshEntity(smallMeadowSlime);
                }
            }
        }

        super.remove(reason);
    }

    /* SOUNDS */
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SLIME_BLOCK_PLACE;
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
        this.playSound(SoundEvents.TUFF_BREAK, 0.001F, 0.01F);
    }
}
