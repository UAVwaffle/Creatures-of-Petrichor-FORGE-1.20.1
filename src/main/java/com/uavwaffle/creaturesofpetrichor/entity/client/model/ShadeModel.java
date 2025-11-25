package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.ShadeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShadeModel extends GeoModel<ShadeEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/shade.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/shade.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/shade.animation.json");





    @Override
    public ResourceLocation getModelResource(ShadeEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(ShadeEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(ShadeEntity object) {
        return this.animations;
    }
}