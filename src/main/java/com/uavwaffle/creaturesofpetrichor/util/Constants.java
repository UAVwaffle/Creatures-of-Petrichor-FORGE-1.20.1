package com.uavwaffle.creaturesofpetrichor.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Constants {

    public static final TagKey<Biome> FORGE_NO_DEFAULT_MONSTERS_TAG = ForgeRegistries.BIOMES.tags().createTagKey(new ResourceLocation("forge", "no_default_monsters"));

    public static final List<ItemLike> WOOD_TYPES = Arrays.asList(
            Items.OAK_LOG,
            Items.ACACIA_LOG,
            Items.BIRCH_LOG,
            Items.CHERRY_LOG,
            Items.JUNGLE_LOG,
            Items.DARK_OAK_LOG,
            Items.MANGROVE_LOG,
            Items.SPRUCE_LOG);

    public static ItemLike getRandomWoodType() {
        return Constants.WOOD_TYPES.get(new Random().nextInt(Constants.WOOD_TYPES.size()));
    }
}
