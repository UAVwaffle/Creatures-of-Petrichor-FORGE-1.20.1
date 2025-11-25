package com.uavwaffle.creaturesofpetrichor.entity.client.model;

import com.google.common.collect.Maps;
import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.entity.custom.WillOWispEntity;
import com.uavwaffle.creaturesofpetrichor.entity.varient_enum.WillOWispVarient;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import java.util.Map;

public class WillOWispModel extends GeoModel<WillOWispEntity> {
    private final ResourceLocation animations = new ResourceLocation(CreaturesOfPetrichor.MODID, "animations/will_o_wisp.animation.json");


    private static final Map<WillOWispVarient, ResourceLocation> MODEL_LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(WillOWispVarient.class), (map) -> {
                map.put(WillOWispVarient.BLUE, new ResourceLocation(CreaturesOfPetrichor.MODID,"geo/will_o_wisp/will_o_wisp.geo.json"));
                map.put(WillOWispVarient.GREEN, new ResourceLocation(CreaturesOfPetrichor.MODID,"geo/will_o_wisp/will_o_wisp2.geo.json"));
                map.put(WillOWispVarient.ORANGE, new ResourceLocation(CreaturesOfPetrichor.MODID,"geo/will_o_wisp/will_o_wisp3.geo.json"));
            });

    private static final Map<WillOWispVarient, ResourceLocation> TEXTURE_LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(WillOWispVarient.class), (map) -> {
        map.put(WillOWispVarient.BLUE, new ResourceLocation(CreaturesOfPetrichor.MODID,"textures/entity/will_o_wisp/will_o_wisp.png"));
        map.put(WillOWispVarient.GREEN, new ResourceLocation(CreaturesOfPetrichor.MODID,"textures/entity/will_o_wisp/will_o_wisp2.png"));
        map.put(WillOWispVarient.ORANGE, new ResourceLocation(CreaturesOfPetrichor.MODID,"textures/entity/will_o_wisp/will_o_wisp3.png"));
    });


    @Override
    public ResourceLocation getModelResource(WillOWispEntity object) {
        return MODEL_LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getTextureResource(WillOWispEntity object) {
        return TEXTURE_LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(WillOWispEntity object) {
        return this.animations;
    }

    @Override
    public RenderType getRenderType(WillOWispEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }

}