package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.HauntModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.HauntEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HauntRenderer extends GeoEntityRenderer<HauntEntity> {
    public HauntRenderer(EntityRendererProvider.Context context) {
        super(context, new HauntModel());
    }
}
