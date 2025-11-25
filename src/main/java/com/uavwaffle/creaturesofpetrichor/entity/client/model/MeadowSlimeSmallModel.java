package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.MeadowSlimeSmallEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MeadowSlimeSmallModel extends GeoModel<MeadowSlimeSmallEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/meadow_slime_small.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/meadow_slime_small.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/meadow_slime_small.animation.json");





    @Override
    public ResourceLocation getModelResource(MeadowSlimeSmallEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(MeadowSlimeSmallEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(MeadowSlimeSmallEntity object) {
        return this.animations;
    }
}