package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.DeathKnellModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.DeathKnellEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DeathKnellRenderer extends GeoEntityRenderer<DeathKnellEntity> {
    public DeathKnellRenderer(EntityRendererProvider.Context context) {
        super(context, new DeathKnellModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
