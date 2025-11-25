package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.FallenStarEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FallenStarModel extends GeoModel<FallenStarEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/fallen_star.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/fallen_star.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/fallen_star.animation.json");





    @Override
    public ResourceLocation getModelResource(FallenStarEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(FallenStarEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(FallenStarEntity object) {
        return this.animations;
    }

    @Override
    public void setCustomAnimations(FallenStarEntity animatable, long instanceId, AnimationState<FallenStarEntity> animationState) {

        CoreGeoBone head = getAnimationProcessor().getBone("Head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}