package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.VengefulGravestoneEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VengefulGravestoneModel extends GeoModel<VengefulGravestoneEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/vengeful_gravestone_entity.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/vengeful_gravestone.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/vengeful_gravestone_entity.animation.json");





    @Override
    public ResourceLocation getModelResource(VengefulGravestoneEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(VengefulGravestoneEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(VengefulGravestoneEntity object) {
        return this.animations;
    }
}
