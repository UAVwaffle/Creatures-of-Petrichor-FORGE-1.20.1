package com.uavwaffle.creaturesofpetrichor.block.entity;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CreaturesOfPetrichor.MODID);

    public static final RegistryObject<BlockEntityType<ForgottenGravestoneBlockEntity>> FORGOTTEN_GRAVESTONE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("forgotten_gravestone_block_entity", () ->
                    BlockEntityType.Builder.of(ForgottenGravestoneBlockEntity::new,
                            ModBlocks.FORGOTTEN_GRAVESTONE_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}