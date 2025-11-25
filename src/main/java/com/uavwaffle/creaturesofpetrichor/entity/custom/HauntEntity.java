package com.uavwaffle.creaturesofpetrichor.entity.custom;

import com.uavwaffle.creaturesofpetrichor.entity.custom.goal.PetrichorMeleeAttackGoal;
import com.uavwaffle.creaturesofpetrichor.entity.custom.type.PetrichorSlowFallEntity;
import com.uavwaffle.creaturesofpetrichor.util.Constants;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.UUID;

public class HauntEntity extends PetrichorSlowFallEntity implements NeutralMob {

    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.haunt.idle");
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.haunt.walk");
    public static final RawAnimation ATTACK_ANIMATION = RawAnimation.begin().then("animation.haunt.attack", Animation.LoopType.PLAY_ONCE);

    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private UUID persistentAngerTarget;
    private int remainingPersistentAngerTime;





    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public HauntEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, 13);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 4.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.24f);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }
    protected void addBehaviourGoals() {
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
        this.goalSelector.addGoal(4, new PetrichorMeleeAttackGoal(this, 1.25d, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
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
        return 1.3f;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int pRemainingPersistentAngerTime) {
        this.remainingPersistentAngerTime = pRemainingPersistentAngerTime;

    }

    @Override
    protected void customServerAiStep() {

        this.updatePersistentAnger((ServerLevel)this.level(), true);

        if (this.isAngry()) {
            this.lastHurtByPlayerTime = this.tickCount;
        }
        super.customServerAiStep();
    }

    @Override
    public void setTarget(@javax.annotation.Nullable LivingEntity pLivingEntity) {

        if (pLivingEntity instanceof Player) {
            this.setLastHurtByPlayer((Player)pLivingEntity);
        }

        super.setTarget(pLivingEntity);
    }


        @Override
    public @Nullable UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;

    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID pPersistentAngerTarget) {
        this.persistentAngerTarget = pPersistentAngerTarget;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));

    }

    /* SOUNDS */
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOOD_HIT;
    }
    @Override
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.WOOD_HIT;
    }
    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.WOOD_BREAK;
    }

    @Override
    protected void dropCustomDeathLoot(@NotNull DamageSource source, int looting, boolean recentlyHit) {
        ItemStack itemStack = new ItemStack(Constants.getRandomWoodType());
        itemStack.setCount(Math.min(looting + 1, 4));
        this.spawnAtLocation(itemStack);
        super.dropCustomDeathLoot(source, looting, recentlyHit);
    }
}
