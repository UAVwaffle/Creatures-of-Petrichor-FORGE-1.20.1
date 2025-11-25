package com.uavwaffle.creaturesofpetrichor.item;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.block.ModBlocks;
import com.uavwaffle.creaturesofpetrichor.entity.ModEntities;
import com.uavwaffle.creaturesofpetrichor.item.custom.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreaturesOfPetrichor.MODID);

    public static final RegistryObject<Item> COIN = ITEMS.register("coin",
            () -> new Coin(new Item.Properties()));//PROBLEM: I need to pass in the items for it to convert to and from, but they have not been registered yet
    public static final RegistryObject<Item> TEN_COIN = ITEMS.register("ten_coin",
            () -> new TenCoin(new Item.Properties()));
    public static final RegistryObject<Item> HUNDRED_COIN = ITEMS.register("hundred_coin",
            () -> new HundredCoin(new Item.Properties()));
    public static final RegistryObject<Item> FROG_INGOT = ITEMS.register("frog_ingot",
            () -> new FrogIngot(new Item.Properties()));

    public static final RegistryObject<Item> FORGOTTEN_GRAVESTONE_BLOCK_ITEM = ITEMS.register("forgotten_gravestone_block_entity",
            () -> new BlockItem(ModBlocks.FORGOTTEN_GRAVESTONE_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> MEADOW_SLIME_BUCKET = ITEMS.register("meadow_slime_bucket",
            () -> new petrichorMobBucketItem(ModEntities.MEADOW_SLIME, Fluids.WATER, SoundEvents.SLIME_BLOCK_PLACE,
                    (new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> BOULDER_SPIRIT_SPAWN_EGG = ITEMS.register("boulder_spirit_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BOULDER_SPIRIT, 0x615f5e, 0x1448ab,
                    new Item.Properties()));
    public static final RegistryObject<Item> VENGEFUL_GRAVESTONE_SPAWN_EGG = ITEMS.register("vengeful_gravestone_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.VENGEFUL_GRAVESTONE, 0x615f5e, 0x703a34,
                    new Item.Properties()));
    public static final RegistryObject<Item> DIREWOLF_SPAWN_EGG = ITEMS.register("direwolf_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DIREWOLF, 0x2b2826, 0x701518,
                    new Item.Properties()));
    public static final RegistryObject<Item> HAUNT_SPAWN_EGG = ITEMS.register("haunt_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.HAUNT, 0x3d312b, 0x0e0c13,
                    new Item.Properties()));
    public static final RegistryObject<Item> MEADOW_SLIME_SPAWN_EGG = ITEMS.register("meadow_slime_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MEADOW_SLIME, 0x72c07b, 0x7fa262,
                    new Item.Properties()));
    public static final RegistryObject<Item> MEADOW_SLIME_SMALL_SPAWN_EGG = ITEMS.register("meadow_slime_small_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MEADOW_SLIME_SMALL, 0x72c07b, 0xd4d8be,
                    new Item.Properties()));
    public static final RegistryObject<Item> SHADE_SPAWN_EGG = ITEMS.register("shade_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SHADE, 0x3d312b, 0xb7561f,
                    new Item.Properties()));
    public static final RegistryObject<Item> DEATH_KNELL_SPAWN_EGG = ITEMS.register("death_knell_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DEATH_KNELL, 0xcfa85b, 0x703a34,
                    new Item.Properties()));
    public static final RegistryObject<Item> SPECTER_SPAWN_EGG = ITEMS.register("specter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPECTER, 0x703a34, 0x525c6c,
                    new Item.Properties()));
    public static final RegistryObject<Item> CURSED_DOLL_SPAWN_EGG = ITEMS.register("cursed_doll_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CURSED_DOLL, 0x915642, 0xc28b44,
                    new Item.Properties()));
    public static final RegistryObject<Item> NAMELESS_SPAWN_EGG = ITEMS.register("nameless_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.NAMELESS, 0x9061c1, 0xf2f3f4,
                    new Item.Properties()));
    public static final RegistryObject<Item> SHROOMIN_SPAWN_EGG = ITEMS.register("shroomin_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SHROOMIN, 0xa9362a, 0xd6c6ab,
                    new Item.Properties()));
    public static final RegistryObject<Item> SPRITE_SPAWN_EGG = ITEMS.register("sprite_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPRITE, 0x1c1620, 0x566e2e,
                    new Item.Properties()));
    public static final RegistryObject<Item> WILL_O_WISP_SPAWN_EGG = ITEMS.register("will_o_wisp_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WILL_O_WISP, 0x22c2ff, 0x4df8ee,
                    new Item.Properties()));
    public static final RegistryObject<Item> WANDERING_LANTERN_SPAWN_EGG = ITEMS.register("wandering_lantern_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WANDERING_LANTERN, 0xe9da8a, 0x703a34,
                    new Item.Properties()));
    public static final RegistryObject<Item> FALLEN_STAR_SPAWN_EGG = ITEMS.register("fallen_star_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FALLEN_STAR, 0x60caf6, 0xffff9c,
                    new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
