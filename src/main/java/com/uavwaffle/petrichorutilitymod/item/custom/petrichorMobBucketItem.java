package com.uavwaffle.petrichorutilitymod.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class petrichorMobBucketItem extends MobBucketItem {
    public petrichorMobBucketItem(Supplier<? extends EntityType<?>> fishTypeIn, Fluid fluid, SoundEvent pEmptySound, Item.Properties builder) {
        super(fishTypeIn, () -> fluid, () -> pEmptySound, builder.stacksTo(1));
    }
}
