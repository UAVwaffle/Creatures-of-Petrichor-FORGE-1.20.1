package com.uavwaffle.creaturesofpetrichor.item.custom;

import com.uavwaffle.creaturesofpetrichor.item.ModItems;
import com.uavwaffle.creaturesofpetrichor.util.CoinStar;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FrogIngot extends Item {
    public FrogIngot(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        pLevel.playSound(pPlayer, pPlayer.getOnPos(), SoundEvents.CHAIN_BREAK, SoundSource.PLAYERS,1.0f, 1.0f);
        if(!pLevel.isClientSide()) {
            return CoinStar.coinstar(pLevel, pPlayer, pUsedHand, ModItems.HUNDRED_COIN.get(), ModItems.FROG_INGOT.get(), false, true);
        }

        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }
}
