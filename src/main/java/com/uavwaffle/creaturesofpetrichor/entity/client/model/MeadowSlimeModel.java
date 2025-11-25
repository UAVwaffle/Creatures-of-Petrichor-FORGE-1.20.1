package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.MeadowSlimeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MeadowSlimeModel extends GeoModel<MeadowSlimeEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/meadow_slime.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/meadow_slime.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/meadow_slime.animation.json");





    @Override
    public ResourceLocation getModelResource(MeadowSlimeEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(MeadowSlimeEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(MeadowSlimeEntity object) {
        return this.animations;
    }
}