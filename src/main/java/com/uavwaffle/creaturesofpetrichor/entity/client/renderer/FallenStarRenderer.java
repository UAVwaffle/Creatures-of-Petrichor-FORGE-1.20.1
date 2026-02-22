package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.FallenStarModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.FallenStarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class FallenStarRenderer extends GeoEntityRenderer<FallenStarEntity> {
    public FallenStarRenderer(EntityRendererProvider.Context context) {
        super(context, new FallenStarModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
