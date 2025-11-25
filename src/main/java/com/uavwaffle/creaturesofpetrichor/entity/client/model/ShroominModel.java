package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.google.common.collect.Maps;
import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.ShroominEntity;
import com.uavwaffle.creaturesofpetrichor.entity.varient_enum.ShroominVarient;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import java.util.Map;

public class ShroominModel extends GeoModel<ShroominEntity> {
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/shroomin.animation.json");

    private static final Map<ShroominVarient, ResourceLocation> MODEL_LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ShroominVarient.class), (map) -> {
                map.put(ShroominVarient.RED, new ResourceLocation(CreaturesOfPetrichor.MODID,"geo/shroomin/shroomin.geo.json"));
                map.put(ShroominVarient.BROWN, new ResourceLocation(CreaturesOfPetrichor.MODID,"geo/shroomin/shroomin2.geo.json"));
            });

    private static final Map<ShroominVarient, ResourceLocation> TEXTURE_LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ShroominVarient.class), (map) -> {
                map.put(ShroominVarient.RED, new ResourceLocation(CreaturesOfPetrichor.MODID,"textures/entity/shroomin/shroomin.png"));
                map.put(ShroominVarient.BROWN, new ResourceLocation(CreaturesOfPetrichor.MODID,"textures/entity/shroomin/shroomin2.png"));
            });





    @Override
    public ResourceLocation getModelResource(ShroominEntity object) {
        return MODEL_LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getTextureResource(ShroominEntity object) {
        return TEXTURE_LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(ShroominEntity object) {
        return this.animations;
    }
}