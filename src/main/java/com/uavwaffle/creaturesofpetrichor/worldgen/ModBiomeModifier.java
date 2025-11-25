package com.uavwaffle.creaturesofpetrichor.worldgen;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifier {

    public static final ResourceKey<BiomeModifier> SPAWN_SPRITE = registerKey("spawn_sprite");
    public static final ResourceKey<BiomeModifier> SPAWN_WILL_O_WISP = registerKey("spawn_will_o_wisp");
//
//    public static final ResourceKey<BiomeModifier> SPAWN_VENGEFUL_GRAVESTONE = registerKey("spawn_vengeful_gravestone");
//    public static final ResourceKey<BiomeModifier> SPAWN_HAUNT = registerKey("spawn_haunt");
//    public static final ResourceKey<BiomeModifier> SPAWN_SHADE = registerKey("spawn_shade");
//    public static final ResourceKey<BiomeModifier> SPAWN_SHROOMIN = registerKey("spawn_shroomin");
//    public static final ResourceKey<BiomeModifier> SPAWN_SPECTER = registerKey("spawn_specter");
//    public static final ResourceKey<BiomeModifier> SPAWN_DIREWOLF = registerKey("spawn_direwolf");
//    public static final ResourceKey<BiomeModifier> SPAWN_WANDERING_LANTERN = registerKey("spawn_wandering_lantern");


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CreaturesOfPetrichor.MODID, name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        /* Vanilla Mob Spawn Weights: https://minecraft.wiki/w/Mob_spawning#Monsters */


//        context.register(SPAWN_SPRITE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_FOREST),
////                biomes.getOrThrow(Tags.Biomes.IS_DENSE_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SPRITE.get(), 10, 3, 5))));
//
//        context.register(SPAWN_WILL_O_WISP, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_FOREST),
////                biomes.getOrThrow(Tags.Biomes.IS_DENSE_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.WILL_O_WISP.get(), 30, 1, 1))));
//
//        context.register(SPAWN_VENGEFUL_GRAVESTONE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.VENGEFUL_GRAVESTONE.get(), 65, 1,1))));
//
//        context.register(SPAWN_HAUNT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.HAUNT.get(), 60, 1,4))));
//
//        context.register(SPAWN_SHADE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SHADE.get(), 60, 1,1))));
//
//        context.register(SPAWN_SHROOMIN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SHROOMIN.get(), 90, 1,5))));
//
//        context.register(SPAWN_SPECTER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SPECTER.get(), 40, 1,1))));
//
//        context.register(SPAWN_DIREWOLF, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.DIREWOLF.get(), 30, 4,8))));
//
//        context.register(SPAWN_WANDERING_LANTERN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//                List.of(new MobSpawnSettings.SpawnerData(ModEntities.WANDERING_LANTERN.get(), 20, 1,1))));

    }
}
