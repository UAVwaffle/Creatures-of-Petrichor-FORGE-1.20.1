package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.NamelessModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.NamelessEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class NamelessRenderer extends GeoEntityRenderer<NamelessEntity> {
    public NamelessRenderer(EntityRendererProvider.Context context) {
        super(context, new NamelessModel());
    }
}
