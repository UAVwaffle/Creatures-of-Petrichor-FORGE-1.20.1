package com.uavwaffle.creaturesofpetrichor.worldgen;

import com.mojang.serialization.Codec;
import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PetrichorMobSpawnBiomeModifier implements BiomeModifier {
    private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(CreaturesOfPetrichor.MODID, "petrichor_mob_spawns"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, CreaturesOfPetrichor.MODID);

    public PetrichorMobSpawnBiomeModifier() {
    }

    // read this: https://forge.gemwire.uk/wiki/Biome_Modifiers

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD) {
            PetrichorWorldRegistry.addBiomeSpawns(biome, builder);
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return SERIALIZER.get();
    }

    public static Codec<PetrichorMobSpawnBiomeModifier> makeCodec() {
        return Codec.unit(PetrichorMobSpawnBiomeModifier::new);
    }
}