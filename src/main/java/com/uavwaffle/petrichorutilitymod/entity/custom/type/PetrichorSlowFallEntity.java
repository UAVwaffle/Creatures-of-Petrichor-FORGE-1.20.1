package com.uavwaffle.petrichorutilitymod.entity.custom.type;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animation.RawAnimation;

public abstract class PetrichorSlowFallEntity extends PetrichorNoFallEntity {
    private double fallSpeed = 0.6D;

    public PetrichorSlowFallEntity(EntityType<? extends Monster> pEntityType, Level pLevel, RawAnimation ATTACK_ANIMATION, int attackAnimationTickLength) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, attackAnimationTickLength);
    }
    public PetrichorSlowFallEntity(EntityType<? extends Monster> pEntityType, Level pLevel, RawAnimation ATTACK_ANIMATION, int attackAnimationTickLength, int attackDamageTickDelay) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, attackAnimationTickLength, attackDamageTickDelay);
    }

    public double getFallSpeed() {
        return fallSpeed;
    }

    public void setFallSpeed(double fallSpeed) {
        this.fallSpeed = fallSpeed;
    }
    @Override
    public void aiStep() {
        super.aiStep();
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && vec3.y < 0.0D) {
            this.setDeltaMovement(vec3.multiply(1.0D, fallSpeed, 1.0D));
        }
    }

    @Override
    protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
        this.playSound(SoundEvents.TUFF_BREAK, 0.001F, 0.01F);
    }
}
