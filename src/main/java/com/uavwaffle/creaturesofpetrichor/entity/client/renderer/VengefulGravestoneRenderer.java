package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.VengefulGravestoneModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.VengefulGravestoneEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VengefulGravestoneRenderer extends GeoEntityRenderer<VengefulGravestoneEntity> {
    public VengefulGravestoneRenderer(EntityRendererProvider.Context context) {
        super(context, new VengefulGravestoneModel());
    }
}
