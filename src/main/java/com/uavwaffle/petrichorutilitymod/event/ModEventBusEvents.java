package com.uavwaffle.petrichorutilitymod.event;

import com.uavwaffle.petrichorutilitymod.PetrichorUtilityMod;
import com.uavwaffle.petrichorutilitymod.entity.ModEntities;
import com.uavwaffle.petrichorutilitymod.entity.custom.*;
import com.uavwaffle.petrichorutilitymod.util.Util;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PetrichorUtilityMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BOULDER_SPIRIT.get(), BoulderSpiritEntity.createAttributes().build());
        event.put(ModEntities.VENGEFUL_GRAVESTONE.get(), VengefulGravestoneEntity.createAttributes().build());
        event.put(ModEntities.DIREWOLF.get(), DirewolfEntity.createAttributes().build());
        event.put(ModEntities.HAUNT.get(), HauntEntity.createAttributes().build());
        event.put(ModEntities.MEADOW_SLIME.get(), MeadowSlimeEntity.createAttributes().build());
        event.put(ModEntities.MEADOW_SLIME_SMALL.get(), MeadowSlimeSmallEntity.createAttributes().build());
        event.put(ModEntities.SHADE.get(), ShadeEntity.createAttributes().build());
        event.put(ModEntities.DEATH_KNELL.get(), DeathKnellEntity.createAttributes().build());
        event.put(ModEntities.SPECTER.get(), SpecterEntity.createAttributes().build());
        event.put(ModEntities.CURSED_DOLL.get(), CursedDollEntity.createAttributes().build());
        event.put(ModEntities.NAMELESS.get(), NamelessEntity.createAttributes().build());
        event.put(ModEntities.SHROOMIN.get(), ShroominEntity.createAttributes().build());
        event.put(ModEntities.SPRITE.get(), SpriteEntity.createAttributes().build());
        event.put(ModEntities.WILL_O_WISP.get(), WillOWispEntity.createAttributes().build());
        event.put(ModEntities.WANDERING_LANTERN.get(), WanderingLanternEntity.createAttributes().build());
        event.put(ModEntities.FALLEN_STAR.get(), FallenStarEntity.createAttributes().build());

    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        /* Vanilla spawn placements: package net.minecraft.world.entity; public class SpawnPlacements */
        event.register(ModEntities.SPRITE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Util.PetrichorSpawnRules::checkAnimalSpawnRulesIgnoreLight, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.WILL_O_WISP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Util.PetrichorSpawnRules::checkAnimalSpawnRulesInDarkness, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.CURSED_DOLL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.WANDERING_LANTERN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.HAUNT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.SHADE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.SHROOMIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.SPECTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.DIREWOLF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.VENGEFUL_GRAVESTONE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
