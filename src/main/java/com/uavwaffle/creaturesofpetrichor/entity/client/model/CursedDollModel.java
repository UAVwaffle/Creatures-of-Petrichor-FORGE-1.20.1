package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.CursedDollEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedDollModel extends GeoModel<CursedDollEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/cursed_doll.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/cursed_doll.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/cursed_doll.animation.json");





    @Override
    public ResourceLocation getModelResource(CursedDollEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(CursedDollEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(CursedDollEntity object) {
        return this.animations;
    }
}