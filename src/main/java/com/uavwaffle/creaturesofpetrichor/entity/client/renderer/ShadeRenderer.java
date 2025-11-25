package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.ShadeModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.ShadeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShadeRenderer extends GeoEntityRenderer<ShadeEntity> {
    public ShadeRenderer(EntityRendererProvider.Context context) {
        super(context, new ShadeModel());
    }
}
