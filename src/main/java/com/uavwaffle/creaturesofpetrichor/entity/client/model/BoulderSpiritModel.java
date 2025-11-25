package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.BoulderSpiritEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BoulderSpiritModel extends GeoModel<BoulderSpiritEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/boulder_spirit.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/boulder_spirit.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/boulder_spirit.animation.json");





    @Override
    public ResourceLocation getModelResource(BoulderSpiritEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(BoulderSpiritEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(BoulderSpiritEntity object) {
        return this.animations;
    }
}
