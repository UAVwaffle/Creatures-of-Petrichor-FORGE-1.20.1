package com.uavwaffle.creaturesofpetrichor.entity.custom.type;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animation.RawAnimation;

public abstract class PetrichorNoFallEntity extends PetrichorAttackingEntity {
    public PetrichorNoFallEntity(EntityType<? extends Monster> pEntityType, Level pLevel, RawAnimation ATTACK_ANIMATION, int attackAnimationTickLength) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, attackAnimationTickLength);
    }
    public PetrichorNoFallEntity(EntityType<? extends Monster> pEntityType, Level pLevel, RawAnimation ATTACK_ANIMATION, int attackAnimationTickLength, int attackDamageTickDelay) {
        super(pEntityType, pLevel, ATTACK_ANIMATION, attackAnimationTickLength, attackDamageTickDelay);
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, @NotNull DamageSource pSource) {
        return false;
    }
}
