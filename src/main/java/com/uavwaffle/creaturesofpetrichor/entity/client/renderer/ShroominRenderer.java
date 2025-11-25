package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.ShroominModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.ShroominEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShroominRenderer extends GeoEntityRenderer<ShroominEntity> {
    public ShroominRenderer(EntityRendererProvider.Context context) {
        super(context, new ShroominModel());
    }
}
