package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.SpecterModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.SpecterEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpecterRenderer extends GeoEntityRenderer<SpecterEntity> {
    public SpecterRenderer(EntityRendererProvider.Context context) {
        super(context, new SpecterModel());
    }
}
