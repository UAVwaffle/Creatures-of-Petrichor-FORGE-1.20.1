package com.uavwaffle.petrichorutilitymod.worldgen;

import com.uavwaffle.petrichorutilitymod.Config;
import com.uavwaffle.petrichorutilitymod.PetrichorUtilityMod;
import com.uavwaffle.petrichorutilitymod.entity.ModEntities;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PetrichorUtilityMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PetrichorWorldRegistry {

    private static ResourceLocation getBiomeName(Holder<Biome> biome) {
        return biome.unwrap().map(ResourceKey::location, (noKey) -> null);
    }

    public static boolean testBiome(TagKey<Biome> entry, Holder<Biome> biome) {
        boolean result = false;
        try {
            result = biome.containsTag(entry);
        } catch (Exception e) {
            PetrichorUtilityMod.LOGGER.warn("could not test biome config for {}, defaulting to no spawns for mob", getBiomeName(biome).getNamespace());
        }
        return result;
    }

    public static void addBiomeSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {

        if (testBiome(Config.CURSED_DOLL_BIOME_TAG, biome) && Config.cursedDollSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.CURSED_DOLL.get(), Config.cursedDollSpawnWeight, Config.cursedDollMinSpawnCount, Config.cursedDollMaxSpawnCount));
        }

        if (testBiome(Config.DIREWOLF_BIOME_TAG, biome) && Config.direwolfSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.DIREWOLF.get(), Config.direwolfSpawnWeight, Config.direwolfMinSpawnCount, Config.direwolfMaxSpawnCount));
        }

        if (testBiome(Config.HAUNT_BIOME_TAG, biome) && Config.hauntSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.HAUNT.get(), Config.hauntSpawnWeight, Config.hauntMinSpawnCount, Config.hauntMaxSpawnCount));
        }

        if (testBiome(Config.SHADE_BIOME_TAG, biome) && Config.shadeSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.SHADE.get(), Config.shadeSpawnWeight, Config.shadeMinSpawnCount, Config.shadeMaxSpawnCount));
        }

        if (testBiome(Config.SHROOMIN_BIOME_TAG, biome) && Config.shroominSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.SHROOMIN.get(), Config.shroominSpawnWeight, Config.shroominMinSpawnCount, Config.shroominMaxSpawnCount));
        }

        if (testBiome(Config.SPECTER_BIOME_TAG, biome) && Config.specterSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.SPECTER.get(), Config.specterSpawnWeight, Config.specterMinSpawnCount, Config.specterMaxSpawnCount));
        }

        if (testBiome(Config.SPRITE_BIOME_TAG, biome) && Config.spriteSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.AMBIENT)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.SPRITE.get(), Config.spriteSpawnWeight, Config.spriteMinSpawnCount, Config.spriteMaxSpawnCount));
        }

        if (testBiome(Config.VENGEFUL_GRAVESTONE_BIOME_TAG, biome) && Config.vengefulGravestoneSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.VENGEFUL_GRAVESTONE.get(), Config.vengefulGravestoneSpawnWeight, Config.vengefulGravestoneMinSpawnCount, Config.vengefulGravestoneMaxSpawnCount));
        }

        if (testBiome(Config.WANDINGER_LANTERN_BIOME_TAG, biome) && Config.wanderingLanternSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.WANDERING_LANTERN.get(), Config.wanderingLanternSpawnWeight, Config.wanderingLanternMinSpawnCount, Config.wanderingLanternMaxSpawnCount));
        }

        if (testBiome(Config.WILL_O_WISP_BIOME_TAG, biome) && Config.willOWispSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.AMBIENT)
                    .add(new MobSpawnSettings.SpawnerData(ModEntities.WILL_O_WISP.get(), Config.willOWispSpawnWeight, Config.willOWispMinSpawnCount, Config.willOWispMaxSpawnCount));
        }


    }
}
