package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.MeadowSlimeSmallModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.MeadowSlimeSmallEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MeadowSlimeSmallRenderer extends GeoEntityRenderer<MeadowSlimeSmallEntity> {
    public MeadowSlimeSmallRenderer(EntityRendererProvider.Context context) {
        super(context, new MeadowSlimeSmallModel());
    }
}
