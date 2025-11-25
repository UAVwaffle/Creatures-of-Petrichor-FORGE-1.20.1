package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.NamelessEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NamelessModel extends GeoModel<NamelessEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/nameless.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/nameless.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/nameless.animation.json");





    @Override
    public ResourceLocation getModelResource(NamelessEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(NamelessEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(NamelessEntity object) {
        return this.animations;
    }
}