package com.uavwaffle.creaturesofpetrichor.util.id;

import com.google.common.collect.Sets;
import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class ModLootTables {

    /*
    Vanilla version of this is in: package net.minecraft.world.level.storage.loot; BuiltInLootTables
     */

    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);
    public static final ResourceLocation EMPTY = new ResourceLocation("empty");
    public static final ResourceLocation SHROOMIN_RED = register("entities/shroomin/red");
    public static final ResourceLocation SHROOMIN_BROWN = register("entities/shroomin/brown");

    private static ResourceLocation register(String pId) {
        return register(new ResourceLocation(CreaturesOfPetrichor.MODID, pId));
    }

    private static ResourceLocation register(ResourceLocation pId) {
        if (LOCATIONS.add(pId)) {
            return pId;
        } else {
            throw new IllegalArgumentException(pId + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}
