package com.uavwaffle.creaturesofpetrichor.block.entity.client;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.block.entity.ForgottenGravestoneBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ForgottenGravestoneBlockEntityModel extends GeoModel<ForgottenGravestoneBlockEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/forgotten_gravestone_block.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/vengeful_gravestone.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/forgotten_gravestone_block.animation.json");





    @Override
    public ResourceLocation getModelResource(ForgottenGravestoneBlockEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(ForgottenGravestoneBlockEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(ForgottenGravestoneBlockEntity object) {
        return this.animations;
    }
}