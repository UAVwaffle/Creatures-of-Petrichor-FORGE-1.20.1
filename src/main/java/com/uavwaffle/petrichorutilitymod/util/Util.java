package com.uavwaffle.petrichorutilitymod.util;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.dimension.DimensionType;

public class Util {

    public static class PetrichorSpawnRules {
        public static boolean checkAnimalSpawnRules(EntityType<? extends Mob> mob, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
            return pLevel.getBlockState(pPos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && isBrightEnoughToSpawn(pLevel, pPos);
        }

        public static boolean checkMonsterSpawnRules(EntityType<? extends Mob> pType, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
            return pLevel.getDifficulty() != Difficulty.PEACEFUL && isDarkEnoughToSpawn(pLevel, pPos, pRandom) && checkMobSpawnRules(pType, pLevel, pSpawnType, pPos, pRandom);
        }

        public static boolean checkMobSpawnRules(EntityType<? extends Mob> pType, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
            BlockPos blockpos = pPos.below();
            return pSpawnType == MobSpawnType.SPAWNER || pLevel.getBlockState(blockpos).isValidSpawn(pLevel, blockpos, pType);
        }

        protected static boolean isBrightEnoughToSpawn(BlockAndTintGetter pLevel, BlockPos pPos) {
            return pLevel.getRawBrightness(pPos, 0) > 8;
        }

        public static boolean checkAnimalSpawnRulesIgnoreLight(EntityType<? extends Mob> mob, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
            return pLevel.getBlockState(pPos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON);
        }

        public static boolean checkAnimalSpawnRulesInDarkness(EntityType<? extends Mob> mob, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
            return pLevel.getBlockState(pPos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && isDarkEnoughToSpawn(pLevel, pPos, pRandom);
        }

        public static boolean isDarkEnoughToSpawn(ServerLevelAccessor pLevel, BlockPos pPos, RandomSource pRandom) {
            if (pLevel.getBrightness(LightLayer.SKY, pPos) > pRandom.nextInt(32)) {
                return false;
            } else {
                DimensionType dimensiontype = pLevel.dimensionType();
                int i = dimensiontype.monsterSpawnBlockLightLimit();
                if (i < 15 && pLevel.getBrightness(LightLayer.BLOCK, pPos) > i) {
                    return false;
                } else {
                    int j = pLevel.getLevel().isThundering() ? pLevel.getMaxLocalRawBrightness(pPos, 10) : pLevel.getMaxLocalRawBrightness(pPos);
                    return j <= dimensiontype.monsterSpawnLightTest().sample(pRandom);
                }
            }
        }
    }
}
