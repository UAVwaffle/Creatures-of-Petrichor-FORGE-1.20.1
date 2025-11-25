package com.uavwaffle.creaturesofpetrichor.item;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {

    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreaturesOfPetrichor.MODID);

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> PETRICHOR_TAB = CREATIVE_MODE_TABS.register("petrichor_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FROG_INGOT.get()))
            .title(Component.translatable("creativetab.petrichor_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.COIN.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(ModItems.TEN_COIN.get());
                output.accept(ModItems.HUNDRED_COIN.get());
                output.accept(ModItems.FROG_INGOT.get());

                output.accept(ModItems.FORGOTTEN_GRAVESTONE_BLOCK_ITEM.get());

                output.accept(ModItems.MEADOW_SLIME_BUCKET.get());

                output.accept(ModItems.BOULDER_SPIRIT_SPAWN_EGG.get());
                output.accept(ModItems.VENGEFUL_GRAVESTONE_SPAWN_EGG.get());
                output.accept(ModItems.DIREWOLF_SPAWN_EGG.get());
                output.accept(ModItems.HAUNT_SPAWN_EGG.get());
                output.accept(ModItems.MEADOW_SLIME_SPAWN_EGG.get());
                output.accept(ModItems.MEADOW_SLIME_SMALL_SPAWN_EGG.get());
                output.accept(ModItems.SHADE_SPAWN_EGG.get());
                output.accept(ModItems.DEATH_KNELL_SPAWN_EGG.get());
                output.accept(ModItems.SPECTER_SPAWN_EGG.get());
                output.accept(ModItems.CURSED_DOLL_SPAWN_EGG.get());
                output.accept(ModItems.NAMELESS_SPAWN_EGG.get());
                output.accept(ModItems.SHROOMIN_SPAWN_EGG.get());
                output.accept(ModItems.SPRITE_SPAWN_EGG.get());
                output.accept(ModItems.WILL_O_WISP_SPAWN_EGG.get());
                output.accept(ModItems.WANDERING_LANTERN_SPAWN_EGG.get());
                output.accept(ModItems.FALLEN_STAR_SPAWN_EGG.get());



//                output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
//                output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
            }).build());


    // Add the example block item to the building blocks tab
//    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
////        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) // for adding things to vanilla creative tabs
////            event.accept(ModItems.COIN);
//    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
