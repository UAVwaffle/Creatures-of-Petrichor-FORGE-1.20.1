package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.WanderingLanternEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WanderingLanternModel extends GeoModel<WanderingLanternEntity> {
    private final ResourceLocation model = new ResourceLocation(CreaturesOfPetrichor.MODID, "geo/wandering_lantern.geo.json");
    private final ResourceLocation texture = new ResourceLocation(CreaturesOfPetrichor.MODID, "textures/entity/wandering_lantern.png");
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/wandering_lantern.animation.json");





    @Override
    public ResourceLocation getModelResource(WanderingLanternEntity object) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(WanderingLanternEntity object) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(WanderingLanternEntity object) {
        return this.animations;
    }

    @Override
    public void setCustomAnimations(WanderingLanternEntity animatable, long instanceId, AnimationState<WanderingLanternEntity> animationState) {

        CoreGeoBone head = getAnimationProcessor().getBone("Head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}