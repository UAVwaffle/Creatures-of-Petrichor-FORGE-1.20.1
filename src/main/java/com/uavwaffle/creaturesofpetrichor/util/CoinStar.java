package com.uavwaffle.creaturesofpetrichor.util;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CoinStar {

    public static InteractionResultHolder<ItemStack> coinstar(Level pLevel, Player pPlayer, InteractionHand pUsedHand, Item smallerChange, Item largerChange, boolean isSmallest, boolean isLargest) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        if(pPlayer.isCrouching() && !isSmallest) {
            return makeChange(pLevel, pPlayer, pUsedHand, itemstack, smallerChange);
        }
        if (!isLargest) {
            return makeCash(pLevel, pPlayer, pUsedHand, itemstack, largerChange);
        }
        return makeChange(pLevel, pPlayer, pUsedHand, itemstack, smallerChange);
    }

    private static InteractionResultHolder<ItemStack> makeChange(Level pLevel, Player pPlayer, InteractionHand pUsedHand, ItemStack itemstack, Item smallerChange) {
        if (itemstack.getCount() < 1) {
            return InteractionResultHolder.fail(itemstack);
        }
        double d0 = pPlayer.getEyeY() - (double) 0.3F;
        itemstack.shrink(1);
        pLevel.addFreshEntity(new ItemEntity(pLevel, pPlayer.getX(), d0, pPlayer.getZ(), new ItemStack(smallerChange, 10)));
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    private static InteractionResultHolder<ItemStack> makeCash(Level pLevel, Player pPlayer, InteractionHand pUsedHand, ItemStack itemstack, Item largerChange) {
        if (itemstack.getCount() < 10) {
            return InteractionResultHolder.fail(itemstack);
        }
        double d0 = pPlayer.getEyeY() - (double) 0.3F;
        itemstack.shrink(10);
        pLevel.addFreshEntity(new ItemEntity(pLevel, pPlayer.getX(), d0, pPlayer.getZ(), new ItemStack(largerChange, 1)));
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

}
