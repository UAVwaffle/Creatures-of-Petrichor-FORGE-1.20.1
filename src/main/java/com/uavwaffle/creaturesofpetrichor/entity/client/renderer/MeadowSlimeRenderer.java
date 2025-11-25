package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.MeadowSlimeModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.MeadowSlimeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MeadowSlimeRenderer extends GeoEntityRenderer<MeadowSlimeEntity> {
    public MeadowSlimeRenderer(EntityRendererProvider.Context context) {
        super(context, new MeadowSlimeModel());
    }
}
