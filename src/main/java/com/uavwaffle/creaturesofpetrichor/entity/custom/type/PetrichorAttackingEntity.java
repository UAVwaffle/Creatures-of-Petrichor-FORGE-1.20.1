package com.uavwaffle.creaturesofpetrichor.entity.custom.type;

import com.uavwaffle.creaturesofpetrichor.util.Constants;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

public abstract class PetrichorAttackingEntity extends Monster implements GeoEntity {
    private final int attackAnimationTickLength;
    private final int attackDamageTickDelay;

    private int ticksUntilNextAttack;
    private int ticksUntilAttackDamage;
    private boolean attacked;
    private boolean attacking;
    private boolean cancelDamage;

    private final RawAnimation ATTACK_ANIMATION;

    public PetrichorAttackingEntity(EntityType<? extends Monster> entityType, Level level, RawAnimation ATTACK_ANIMATION, int attackAnimationTickLength) {
        this(entityType, level, ATTACK_ANIMATION, attackAnimationTickLength, (attackAnimationTickLength/2));
    }
    public PetrichorAttackingEntity(EntityType<? extends Monster> entityType, Level level, RawAnimation ATTACK_ANIMATION, int attackAnimationTickLength, int attackDamageTickDelay) {
        super(entityType, level);
        this.ATTACK_ANIMATION = ATTACK_ANIMATION;
        this.attackAnimationTickLength = attackAnimationTickLength;

        this.ticksUntilAttackDamage = 0;
        this.attackDamageTickDelay = attackDamageTickDelay;
        this.attacked = false;
        this.attacking = false;
        this.cancelDamage = false;
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (level().isClientSide) {
            return;
        }
        this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        this.ticksUntilAttackDamage = Math.max(this.ticksUntilAttackDamage - 1, 0);

        attackEntity();

    }

    public void startAttackSequence(){
        if (attacking) {
            return;
        }
        attacked = false;
        attacking = true;
        cancelDamage = false;
        playAttackAnimation();
        resetAttackCooldown();
    }

    public void attackEntity() {
        if (!attacking) {
            return;
        }

        if (ticksUntilNextAttack <= 0) {
            attacking = false;
        }

        if (ticksUntilAttackDamage <= 0 && !attacked) {
            if (getTarget() == null) {
                return;
            }
            attacked = true;
            doHurtTarget(getTarget());
        }
    }

    public void resetAttackCooldown() {
        this.ticksUntilNextAttack = attackAnimationTickLength;
        this.ticksUntilAttackDamage = attackDamageTickDelay;
    }

    public void cancelDamage() {
        cancelDamage = true;
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity pEntity) {
        if (cancelDamage) {
            return false;
        }
        return super.doHurtTarget(pEntity);
    }

    public int getAttackAnimationTickLength() {
        return attackAnimationTickLength;
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 4) {
            playAttackAnimation();
        } else {
            super.handleEntityEvent(pId);
        }

    }



    public void playAttackAnimation() {
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)4);
        }
        triggerAnim("AttackController", "Attack");
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "AttackController", state -> PlayState.STOP).triggerableAnim("Attack", ATTACK_ANIMATION));
    }

    @Override
    public boolean checkSpawnRules(@NotNull LevelAccessor pLevel, @NotNull MobSpawnType pSpawnReason) {
        if(pSpawnReason != MobSpawnType.NATURAL){
            return super.checkSpawnRules(pLevel, pSpawnReason);
        }

        if(pLevel.getBiome(this.getOnPos()).containsTag(Constants.FORGE_NO_DEFAULT_MONSTERS_TAG)) {
            return false;
        }

        if(pLevel.getBiome(this.getOnPos()).containsTag(Tags.Biomes.IS_MUSHROOM)) {
            return false;
        }

        if(pLevel.getBiome(this.getOnPos()).is(Biomes.DEEP_DARK)) {
            return false;
        }

        return  true;
    }

}
