package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.DeathKnellEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DeathKnellModel extends GeoModel<DeathKnellEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/death_knell.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/death_knell.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/death_knell.animation.json");





    @Override
    public ResourceLocation getModelResource(DeathKnellEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(DeathKnellEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(DeathKnellEntity object) {
        return this.animations;
    }
}