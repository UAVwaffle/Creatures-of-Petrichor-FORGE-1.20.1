package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.DirewolfModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.DirewolfEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DirewolfRenderer extends GeoEntityRenderer<DirewolfEntity> {
    public DirewolfRenderer(EntityRendererProvider.Context context) {
        super(context, new DirewolfModel());
    }
}
