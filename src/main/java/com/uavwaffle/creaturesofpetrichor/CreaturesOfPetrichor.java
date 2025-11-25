package com.uavwaffle.creaturesofpetrichor;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.uavwaffle.creaturesofpetrichor.block.ModBlocks;
import com.uavwaffle.creaturesofpetrichor.block.entity.ModBlockEntities;
import com.uavwaffle.creaturesofpetrichor.block.entity.client.ForgottenGravestoneBlockEntityRenderer;
import com.uavwaffle.creaturesofpetrichor.entity.client.renderer.*;
import com.uavwaffle.creaturesofpetrichor.item.CreativeTabs;
import com.uavwaffle.creaturesofpetrichor.entity.ModEntities;
import com.uavwaffle.creaturesofpetrichor.item.ModItems;
import com.uavwaffle.creaturesofpetrichor.worldgen.PetrichorMobSpawnBiomeModifier;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreaturesOfPetrichor.MODID)
public class CreaturesOfPetrichor {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "creatures_of_petrichor";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();



    public CreaturesOfPetrichor() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);


        final DeferredRegister<Codec<? extends BiomeModifier>> biomeModifiers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, CreaturesOfPetrichor.MODID);
        biomeModifiers.register(modEventBus);
        biomeModifiers.register("petrichor_mob_spawns", PetrichorMobSpawnBiomeModifier::makeCodec);

        CreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        GeckoLib.initialize();


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code


            BlockEntityRenderers.register(ModBlockEntities.FORGOTTEN_GRAVESTONE_BLOCK_ENTITY.get(), ForgottenGravestoneBlockEntityRenderer::new);

            EntityRenderers.register(ModEntities.BOULDER_SPIRIT.get(), BoulderSpiritRenderer::new);
            EntityRenderers.register(ModEntities.VENGEFUL_GRAVESTONE.get(), VengefulGravestoneRenderer::new);
            EntityRenderers.register(ModEntities.DIREWOLF.get(), DirewolfRenderer::new);
            EntityRenderers.register(ModEntities.HAUNT.get(), HauntRenderer::new);
            EntityRenderers.register(ModEntities.MEADOW_SLIME.get(), MeadowSlimeRenderer::new);
            EntityRenderers.register(ModEntities.MEADOW_SLIME_SMALL.get(), MeadowSlimeSmallRenderer::new);
            EntityRenderers.register(ModEntities.SHADE.get(), ShadeRenderer::new);
            EntityRenderers.register(ModEntities.DEATH_KNELL.get(), DeathKnellRenderer::new);
            EntityRenderers.register(ModEntities.SPECTER.get(), SpecterRenderer::new);
            EntityRenderers.register(ModEntities.CURSED_DOLL.get(), CursedDollRenderer::new);
            EntityRenderers.register(ModEntities.NAMELESS.get(), NamelessRenderer::new);
            EntityRenderers.register(ModEntities.SHROOMIN.get(), ShroominRenderer::new);
            EntityRenderers.register(ModEntities.SPRITE.get(), SpriteRenderer::new);
            EntityRenderers.register(ModEntities.WILL_O_WISP.get(), WillOWispRenderer::new);
            EntityRenderers.register(ModEntities.WANDERING_LANTERN.get(), WanderingLanternRenderer::new);
            EntityRenderers.register(ModEntities.FALLEN_STAR.get(), FallenStarRenderer::new);


        }
    }
}
