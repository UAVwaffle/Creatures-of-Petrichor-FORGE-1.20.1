package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.BoulderSpiritModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.BoulderSpiritEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BoulderSpiritRenderer extends GeoEntityRenderer<BoulderSpiritEntity> {
    public BoulderSpiritRenderer(EntityRendererProvider.Context context) {
        super(context, new BoulderSpiritModel());
    }
}
