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


//    // Create a Deferred Register to hold Blocks which will all be registered under the "creatures_of_petrichor" namespace
//    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
//    // Create a Deferred Register to hold Items which will all be registered under the "creatures_of_petrichor" namespace
//    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

//
//    // Creates a new Block with the id "creatures_of_petrichor:example_block", combining the namespace and path
//    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
//    // Creates a new BlockItem with the id "creatures_of_petrichor:example_block", combining the namespace and path
//    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));
//
//    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
//    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//            .alwaysEat().nutrition(1).saturationMod(2f).build())));



//    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
//    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
//
//    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
//    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
//            .withTabsBefore(CreativeModeTabs.COMBAT)
//            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
//            .displayItems((parameters, output) -> {
//                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
//            }).build());



    public CreaturesOfPetrichor() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        final DeferredRegister<Codec<? extends BiomeModifier>> biomeModifiers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, CreaturesOfPetrichor.MODID);
        biomeModifiers.register(modEventBus);
        biomeModifiers.register("petrichor_mob_spawns", PetrichorMobSpawnBiomeModifier::makeCodec);
        //register Items and creative tabs here!

//        // Register the Deferred Register to the mod event bus so blocks get registered
//        BLOCKS.register(modEventBus);
//        // Register the Deferred Register to the mod event bus so items get registered
//        ITEMS.register(modEventBus);
//        // Register the Deferred Register to the mod event bus so tabs get registered
        CreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        GeckoLib.initialize();


//        System.out.println("Start biomeModifiers");
//
//        System.out.println("End biomeModifiers");


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
//        modEventBus.addListener(CreativeTabs::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
//        LOGGER.info("HELLO FROM COMMON SETUP");
//        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
//
//        if (Config.logDirtBlock)
//            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
//
//        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
//
//        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

//    // Add the example block item to the building blocks tab
//    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(EXAMPLE_BLOCK_ITEM);
//    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
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
