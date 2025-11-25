package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.WanderingLanternModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.WanderingLanternEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WanderingLanternRenderer extends GeoEntityRenderer<WanderingLanternEntity> {
    public WanderingLanternRenderer(EntityRendererProvider.Context context) {
        super(context, new WanderingLanternModel());
    }
}
