package com.uavwaffle.creaturesofpetrichor.block.entity.client;

import com.uavwaffle.creaturesofpetrichor.block.entity.ForgottenGravestoneBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ForgottenGravestoneBlockEntityRenderer extends GeoBlockRenderer<ForgottenGravestoneBlockEntity> {
    public ForgottenGravestoneBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new ForgottenGravestoneBlockEntityModel());
    }
}