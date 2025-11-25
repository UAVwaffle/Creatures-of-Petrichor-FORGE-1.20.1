package com.uavwaffle.creaturesofpetrichor.entity.client.renderer;

import com.uavwaffle.creaturesofpetrichor.entity.client.model.CursedDollModel;
import com.uavwaffle.creaturesofpetrichor.entity.custom.CursedDollEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CursedDollRenderer extends GeoEntityRenderer<CursedDollEntity> {
    public CursedDollRenderer(EntityRendererProvider.Context context) {
        super(context, new CursedDollModel());
    }
}
