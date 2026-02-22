package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.BoulderSpiritModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.BoulderSpiritEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class BoulderSpiritRenderer extends GeoEntityRenderer<BoulderSpiritEntity> {
    public BoulderSpiritRenderer(EntityRendererProvider.Context context) {
        super(context, new BoulderSpiritModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
