package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.WillOWispModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.WillOWispEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WillOWispRenderer extends GeoEntityRenderer<WillOWispEntity> {
    public WillOWispRenderer(EntityRendererProvider.Context context) {
        super(context, new WillOWispModel());
    }
}
