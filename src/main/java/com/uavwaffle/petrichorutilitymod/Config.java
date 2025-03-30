package com.uavwaffle.petrichorutilitymod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = PetrichorUtilityMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

//    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
//            .comment("Default Config Junk")
//            .define("logDirtBlock", true);
//
//    private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
//            .comment("Default Config Junk A magic number")
//            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
//
//    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
//            .comment("Default Config Junk What you want the introduction message to be for the magic number")
//            .define("magicNumberIntroduction", "The magic number is... ");
//
//    // a list of strings that are treated as resource locations for items
//    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
//            .comment("Default Config Junk A list of items to log on common setup.")
//            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);


                                /* Mob Spawns */
    private static final ForgeConfigSpec.IntValue CURSED_DOLL_SPAWN_WEIGHT = BUILDER
             .comment("Cursed Doll spawn weight. Bigger number equals more common")
             .defineInRange("cursedDollSpawnWeight", 50, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue CURSED_DOLL_MIN_SPAWN_COUNT = BUILDER
            .comment("Cursed Doll min spawn count. Bigger number equals more common")
            .defineInRange("cursedDollMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue CURSED_DOLL_MAX_SPAWN_COUNT = BUILDER
            .comment("Cursed Doll max spawn count. Bigger number equals more common")
            .defineInRange("cursedDollMaxSpawnCount", 2, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> CURSED_DOLL_BIOME_TAG_CONFIG = BUILDER
            .comment("Cursed Doll biome tag. This is where the mob will spawn")
            .define("cursedDollBiomeTag", "is_overworld");

    private static final ForgeConfigSpec.IntValue DIREWOLF_SPAWN_WEIGHT = BUILDER
            .comment("Direwolf spawn weight. Bigger number equals more common")
            .defineInRange("direwolfSpawnWeight", 30, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue DIREWOLF_MIN_SPAWN_COUNT = BUILDER
            .comment("Direwolf min spawn count. Bigger number equals more common")
            .defineInRange("direwolfMinSpawnCount", 4, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue DIREWOLF_MAX_SPAWN_COUNT = BUILDER
            .comment("Direwolf max spawn count. Bigger number equals more common")
            .defineInRange("direwolfMaxSpawnCount", 8, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> DIREWOLF_BIOME_TAG_CONFIG = BUILDER
            .comment("Direwolf biome tag. This is where the mob will spawn")
            .define("direwolfBiomeTag", "is_overworld");

    private static final ForgeConfigSpec.IntValue HAUNT_SPAWN_WEIGHT = BUILDER
            .comment("Haunt spawn weight. Bigger number equals more common")
            .defineInRange("hauntSpawnWeight", 60, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue HAUNT_MIN_SPAWN_COUNT = BUILDER
            .comment("Haunt min spawn count. Bigger number equals more common")
            .defineInRange("hauntMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue HAUNT_MAX_SPAWN_COUNT = BUILDER
            .comment("Haunt max spawn count. Bigger number equals more common")
            .defineInRange("hauntMaxSpawnCount", 4, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> HAUNT_BIOME_TAG_CONFIG = BUILDER
            .comment("Haunt biome tag. This is where the mob will spawn")
            .define("hauntBiomeTag", "is_overworld");

    private static final ForgeConfigSpec.IntValue MEADOW_SLIME_SPAWN_WEIGHT = BUILDER
            .comment("Meadow Slime spawn weight. Bigger number equals more common")
            .defineInRange("meadowSlimeSpawnWeight", 50, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue MEADOW_SLIME_MIN_SPAWN_COUNT = BUILDER
            .comment("Meadow Slime min spawn count. Bigger number equals more common")
            .defineInRange("meadowSlimeMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue MEADOW_SLIME_MAX_SPAWN_COUNT = BUILDER
            .comment("Meadow Slime max spawn count. Bigger number equals more common")
            .defineInRange("meadowSlimeMaxSpawnCount", 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> MEADOW_SLIME_BIOME_TAG_CONFIG = BUILDER
            .comment("Meadow Slime biome tag. This is where the mob will spawn")
            .define("meadowSlimeBiomeTag", "has_structure/village_plains");

    private static final ForgeConfigSpec.IntValue SHADE_SPAWN_WEIGHT = BUILDER
            .comment("Shade spawn weight. Bigger number equals more common")
            .defineInRange("shadeSpawnWeight", 60, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SHADE_MIN_SPAWN_COUNT = BUILDER
            .comment("Shade min spawn count. Bigger number equals more common")
            .defineInRange("shadeMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SHADE_MAX_SPAWN_COUNT = BUILDER
            .comment("Shade max spawn count. Bigger number equals more common")
            .defineInRange("shadeMaxSpawnCount", 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> SHADE_BIOME_TAG_CONFIG = BUILDER
            .comment("Shade biome tag. This is where the mob will spawn")
            .define("shadeBiomeTag", "is_overworld");

    private static final ForgeConfigSpec.IntValue SHROOMIN_SPAWN_WEIGHT = BUILDER
            .comment("Shroomin spawn weight. Bigger number equals more common")
            .defineInRange("shroominSpawnWeight", 90, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SHROOMIN_MIN_SPAWN_COUNT = BUILDER
            .comment("Shroomin min spawn count. Bigger number equals more common")
            .defineInRange("shroominMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SHROOMIN_MAX_SPAWN_COUNT = BUILDER
            .comment("Shroomin max spawn count. Bigger number equals more common")
            .defineInRange("shroominMaxSpawnCount", 5, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> SHROOMIN_BIOME_TAG_CONFIG = BUILDER
            .comment("Shroomin biome tag. This is where the mob will spawn")
            .define("shroominBiomeTag", "is_overworld");

    private static final ForgeConfigSpec.IntValue SPECTER_SPAWN_WEIGHT = BUILDER
            .comment("Specter spawn weight. Bigger number equals more common")
            .defineInRange("specterSpawnWeight", 40, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SPECTER_MIN_SPAWN_COUNT = BUILDER
            .comment("Specter min spawn count. Bigger number equals more common")
            .defineInRange("specterMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SPECTER_MAX_SPAWN_COUNT = BUILDER
            .comment("Specter max spawn count. Bigger number equals more common")
            .defineInRange("specterMaxSpawnCount", 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> SPECTER_BIOME_TAG_CONFIG = BUILDER
            .comment("Specter biome tag. This is where the mob will spawn")
            .define("specterBiomeTag", "is_overworld");

    private static final ForgeConfigSpec.IntValue SPRITE_SPAWN_WEIGHT = BUILDER
            .comment("Sprite spawn weight. Bigger number equals more common")
            .defineInRange("spriteSpawnWeight", 10, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SPRITE_MIN_SPAWN_COUNT = BUILDER
            .comment("Sprite min spawn count. Bigger number equals more common")
            .defineInRange("spriteMinSpawnCount", 3, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SPRITE_MAX_SPAWN_COUNT = BUILDER
            .comment("Sprite max spawn count. Bigger number equals more common")
            .defineInRange("spriteMaxSpawnCount", 5, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> SPRITE_BIOME_TAG_CONFIG = BUILDER
            .comment("Sprite biome tag. This is where the mob will spawn")
            .define("spriteBiomeTag", "is_forest");

    private static final ForgeConfigSpec.IntValue VENGEFUL_GRAVESTONE_SPAWN_WEIGHT = BUILDER
            .comment("Vengeful Gravestone spawn weight. Bigger number equals more common")
            .defineInRange("vengefulGravestoneSpawnWeight", 65, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue VENGEFUL_GRAVESTONE_MIN_SPAWN_COUNT = BUILDER
            .comment("Vengeful Gravestone min spawn count. Bigger number equals more common")
            .defineInRange("vengefulGravestoneMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue VENGEFUL_GRAVESTONE_MAX_SPAWN_COUNT = BUILDER
            .comment("Vengeful Gravestone max spawn count. Bigger number equals more common")
            .defineInRange("vengefulGravestoneMaxSpawnCount", 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> VENGEFUL_GRAVESTONE_BIOME_TAG_CONFIG = BUILDER
            .comment("Vengeful Gravestone biome tag. This is where the mob will spawn")
            .define("vengefulGravestoneBiomeTag", "is_overworld");

    private static final ForgeConfigSpec.IntValue WANDINGER_LANTERN_SPAWN_WEIGHT = BUILDER
            .comment("Wandering Lantern spawn weight. Bigger number equals more common")
            .defineInRange("wanderingLanternSpawnWeight", 20, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue WANDINGER_LANTERN_MIN_SPAWN_COUNT = BUILDER
            .comment("Wandering Lantern min spawn count. Bigger number equals more common")
            .defineInRange("wanderingLanternMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue WANDINGER_LANTERN_MAX_SPAWN_COUNT = BUILDER
            .comment("Wandering Lantern max spawn count. Bigger number equals more common")
            .defineInRange("wanderingLanternMaxSpawnCount", 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> WANDINGER_LANTERN_BIOME_TAG_CONFIG = BUILDER
            .comment("Wandering Lantern biome tag. This is where the mob will spawn")
            .define("wanderingLanternBiomeTag", "is_overworld");

    private static final ForgeConfigSpec.IntValue WILL_O_WISP_SPAWN_WEIGHT = BUILDER
            .comment("Will O Wisp spawn weight. Bigger number equals more common")
            .defineInRange("willOWispSpawnWeight", 30, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue WILL_O_WISP_MIN_SPAWN_COUNT = BUILDER
            .comment("Will O Wisp min spawn count. Bigger number equals more common")
            .defineInRange("willOWispMinSpawnCount", 1, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue WILL_O_WISP_MAX_SPAWN_COUNT = BUILDER
            .comment("Will O Wisp max spawn count. Bigger number equals more common")
            .defineInRange("willOWispMaxSpawnCount", 1, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.ConfigValue<String> WILL_O_WISP_BIOME_TAG_CONFIG = BUILDER
            .comment("Will O Wisp biome tag. This is where the mob will spawn")
            .define("willOWispBiomeTag", "is_forest");



    static final ForgeConfigSpec SPEC = BUILDER.build();

//    public static boolean logDirtBlock;
//    public static int magicNumber;
//    public static String magicNumberIntroduction;
//    public static Set<Item> items;

                    /* Mob Spawns */
    public static int cursedDollSpawnWeight;
    public static int cursedDollMinSpawnCount;
    public static int cursedDollMaxSpawnCount;
    public static TagKey<Biome> CURSED_DOLL_BIOME_TAG;

    public static int direwolfSpawnWeight;
    public static int direwolfMinSpawnCount;
    public static int direwolfMaxSpawnCount;
    public static TagKey<Biome> DIREWOLF_BIOME_TAG;

    public static int hauntSpawnWeight;
    public static int hauntMinSpawnCount;
    public static int hauntMaxSpawnCount;
    public static TagKey<Biome> HAUNT_BIOME_TAG;

    public static int meadowSlimeSpawnWeight;
    public static int meadowSlimeMinSpawnCount;
    public static int meadowSlimeMaxSpawnCount;
    public static TagKey<Biome> MEADOW_SLIME_BIOME_TAG;

    public static int shadeSpawnWeight;
    public static int shadeMinSpawnCount;
    public static int shadeMaxSpawnCount;
    public static TagKey<Biome> SHADE_BIOME_TAG;

    public static int shroominSpawnWeight;
    public static int shroominMinSpawnCount;
    public static int shroominMaxSpawnCount;
    public static TagKey<Biome> SHROOMIN_BIOME_TAG;

    public static int specterSpawnWeight;
    public static int specterMinSpawnCount;
    public static int specterMaxSpawnCount;
    public static TagKey<Biome> SPECTER_BIOME_TAG;

    public static int spriteSpawnWeight;
    public static int spriteMinSpawnCount;
    public static int spriteMaxSpawnCount;
    public static TagKey<Biome> SPRITE_BIOME_TAG;

    public static int vengefulGravestoneSpawnWeight;
    public static int vengefulGravestoneMinSpawnCount;
    public static int vengefulGravestoneMaxSpawnCount;
    public static TagKey<Biome> VENGEFUL_GRAVESTONE_BIOME_TAG;

    public static int wanderingLanternSpawnWeight;
    public static int wanderingLanternMinSpawnCount;
    public static int wanderingLanternMaxSpawnCount;
    public static TagKey<Biome> WANDINGER_LANTERN_BIOME_TAG;

    public static int willOWispSpawnWeight;
    public static int willOWispMinSpawnCount;
    public static int willOWispMaxSpawnCount;
    public static TagKey<Biome> WILL_O_WISP_BIOME_TAG;

    private static boolean validateItemName(final Object obj) {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
//        logDirtBlock = LOG_DIRT_BLOCK.get();
//        magicNumber = MAGIC_NUMBER.get();
//        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();
//
//        // convert the list of strings into a set of items
//        items = ITEM_STRINGS.get().stream()
//                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
//                .collect(Collectors.toSet());

                            /* Mob Spawns */
        cursedDollSpawnWeight = CURSED_DOLL_SPAWN_WEIGHT.get();
        cursedDollMinSpawnCount = CURSED_DOLL_MIN_SPAWN_COUNT.get();
        cursedDollMaxSpawnCount = CURSED_DOLL_MAX_SPAWN_COUNT.get();
        CURSED_DOLL_BIOME_TAG = createBiomeTag(CURSED_DOLL_BIOME_TAG_CONFIG.get());

        direwolfSpawnWeight = DIREWOLF_SPAWN_WEIGHT.get();
        direwolfMinSpawnCount = DIREWOLF_MIN_SPAWN_COUNT.get();
        direwolfMaxSpawnCount = DIREWOLF_MAX_SPAWN_COUNT.get();
        DIREWOLF_BIOME_TAG = createBiomeTag(DIREWOLF_BIOME_TAG_CONFIG.get());

        hauntSpawnWeight = HAUNT_SPAWN_WEIGHT.get();
        hauntMinSpawnCount = HAUNT_MIN_SPAWN_COUNT.get();
        hauntMaxSpawnCount = HAUNT_MAX_SPAWN_COUNT.get();
        HAUNT_BIOME_TAG = createBiomeTag(HAUNT_BIOME_TAG_CONFIG.get());

        meadowSlimeSpawnWeight = MEADOW_SLIME_SPAWN_WEIGHT.get();
        meadowSlimeMinSpawnCount = MEADOW_SLIME_MIN_SPAWN_COUNT.get();
        meadowSlimeMaxSpawnCount = MEADOW_SLIME_MAX_SPAWN_COUNT.get();
        MEADOW_SLIME_BIOME_TAG = createBiomeTag(MEADOW_SLIME_BIOME_TAG_CONFIG.get());

        shadeSpawnWeight = SHADE_SPAWN_WEIGHT.get();
        shadeMinSpawnCount = SHADE_MIN_SPAWN_COUNT.get();
        shadeMaxSpawnCount = SHADE_MAX_SPAWN_COUNT.get();
        SHADE_BIOME_TAG = createBiomeTag(SHADE_BIOME_TAG_CONFIG.get());

        shroominSpawnWeight = SHROOMIN_SPAWN_WEIGHT.get();
        shroominMinSpawnCount = SHROOMIN_MIN_SPAWN_COUNT.get();
        shroominMaxSpawnCount = SHROOMIN_MAX_SPAWN_COUNT.get();
        SHROOMIN_BIOME_TAG = createBiomeTag(SHROOMIN_BIOME_TAG_CONFIG.get());

        specterSpawnWeight = SPECTER_SPAWN_WEIGHT.get();
        specterMinSpawnCount = SPECTER_MIN_SPAWN_COUNT.get();
        specterMaxSpawnCount = SPECTER_MAX_SPAWN_COUNT.get();
        SPECTER_BIOME_TAG = createBiomeTag(SPECTER_BIOME_TAG_CONFIG.get());

        spriteSpawnWeight = SPRITE_SPAWN_WEIGHT.get();
        spriteMinSpawnCount = SPRITE_MIN_SPAWN_COUNT.get();
        spriteMaxSpawnCount = SPRITE_MAX_SPAWN_COUNT.get();
        SPRITE_BIOME_TAG = createBiomeTag(SPRITE_BIOME_TAG_CONFIG.get());

        vengefulGravestoneSpawnWeight = VENGEFUL_GRAVESTONE_SPAWN_WEIGHT.get();
        vengefulGravestoneMinSpawnCount = VENGEFUL_GRAVESTONE_MIN_SPAWN_COUNT.get();
        vengefulGravestoneMaxSpawnCount = VENGEFUL_GRAVESTONE_MAX_SPAWN_COUNT.get();
        VENGEFUL_GRAVESTONE_BIOME_TAG = createBiomeTag(VENGEFUL_GRAVESTONE_BIOME_TAG_CONFIG.get());

        wanderingLanternSpawnWeight = WANDINGER_LANTERN_SPAWN_WEIGHT.get();
        wanderingLanternMinSpawnCount = WANDINGER_LANTERN_MIN_SPAWN_COUNT.get();
        wanderingLanternMaxSpawnCount = WANDINGER_LANTERN_MAX_SPAWN_COUNT.get();
        WANDINGER_LANTERN_BIOME_TAG = createBiomeTag(WANDINGER_LANTERN_BIOME_TAG_CONFIG.get());

        willOWispSpawnWeight = WILL_O_WISP_SPAWN_WEIGHT.get();
        willOWispMinSpawnCount = WILL_O_WISP_MIN_SPAWN_COUNT.get();
        willOWispMaxSpawnCount = WILL_O_WISP_MAX_SPAWN_COUNT.get();
        WILL_O_WISP_BIOME_TAG = createBiomeTag(WILL_O_WISP_BIOME_TAG_CONFIG.get());



    }

    private static TagKey<Biome> createBiomeTag(String pName) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(pName));
    }
}
