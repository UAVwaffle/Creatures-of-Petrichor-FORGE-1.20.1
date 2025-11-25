package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.SpriteModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.SpriteEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpriteRenderer extends GeoEntityRenderer<SpriteEntity> {
    public SpriteRenderer(EntityRendererProvider.Context context) {
        super(context, new SpriteModel());
    }
}
