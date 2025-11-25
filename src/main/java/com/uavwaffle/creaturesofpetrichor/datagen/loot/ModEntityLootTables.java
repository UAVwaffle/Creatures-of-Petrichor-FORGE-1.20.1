package com.uavwaffle.creaturesofpetrichor.datagen.loot;

import com.uavwaffle.creaturesofpetrichor.block.ModBlocks;
import com.uavwaffle.creaturesofpetrichor.entity.ModEntities;
import com.uavwaffle.creaturesofpetrichor.item.ModItems;
import com.uavwaffle.creaturesofpetrichor.util.id.ModLootTables;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class ModEntityLootTables extends EntityLootSubProvider {
    public ModEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    /*
    Vanilla loot tables are in: package net.minecraft.data.loot.packs; VanillaEntityLoot extends EntityLootSubProvider
     */
    @Override
    public void generate() {
        add(ModEntities.BOULDER_SPIRIT.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.COIN.get()))));

        add(ModEntities.VENGEFUL_GRAVESTONE.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.FORGOTTEN_GRAVESTONE_BLOCK_ITEM.get()))
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.25F, 0.01F))));

        add(ModEntities.DIREWOLF.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0,2))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));


        add(ModEntities.HAUNT.get(), LootTable.lootTable());

        add(ModEntities.MEADOW_SLIME.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
                                .when(this.killedByFrog().invert())).add(LootItem.lootTableItem(Items.SLIME_BALL)
                                .apply(SetItemCountFunction
                                        .setCount(ConstantValue.exactly(1.0F)))
                                .when(this.killedByFrog()))));

        add(ModEntities.MEADOW_SLIME_SMALL.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))
                                .when(this.killedByFrog().invert())).add(LootItem.lootTableItem(Items.SLIME_BALL)
                                .apply(SetItemCountFunction
                                        .setCount(ConstantValue.exactly(1.0F)))
                                .when(this.killedByFrog()))));

        add(ModEntities.SHADE.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0,2))
                        .add(LootItem.lootTableItem(Items.BROWN_MUSHROOM)
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

        add(ModEntities.DEATH_KNELL.get(), LootTable.lootTable());
//                .withPool(LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1.0F))
//                        .add(LootItem.lootTableItem(ModBlocks.ALEXANDRITE_BLOCK.get()))));

        add(ModEntities.SPECTER.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0,3))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL)
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

        add(ModEntities.CURSED_DOLL.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0,4))
                        .add(LootItem.lootTableItem(Items.BRICK)
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

        add(ModEntities.NAMELESS.get(), LootTable.lootTable());
//                .withPool(LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1.0F))
//                        .add(LootItem.lootTableItem(ModBlocks.ALEXANDRITE_BLOCK.get()))));

        add(ModEntities.SHROOMIN.get(), LootTable.lootTable());//default
        add(ModEntities.SHROOMIN.get(), ModLootTables.SHROOMIN_RED, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0,2))
                        .add(LootItem.lootTableItem(Items.RED_MUSHROOM)
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));
        add(ModEntities.SHROOMIN.get(), ModLootTables.SHROOMIN_BROWN, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0,2))
                        .add(LootItem.lootTableItem(Items.BROWN_MUSHROOM)
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));


        add(ModEntities.SPRITE.get(), LootTable.lootTable());

        add(ModEntities.WILL_O_WISP.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(0,2))
                        .add(LootItem.lootTableItem(Items.GLOWSTONE_DUST)
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

        add(ModEntities.WANDERING_LANTERN.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().when(LootItemKilledByPlayerCondition.killedByPlayer())
                        .setRolls(UniformGenerator.between(1, 3))
                        .add(LootItem.lootTableItem(Blocks.GLOWSTONE.asItem()))));

        add(ModEntities.FALLEN_STAR.get(), LootTable.lootTable());
//                .withPool(LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1.0F))
//                        .add(LootItem.lootTableItem(ModBlocks.ALEXANDRITE_BLOCK.get()))));
    }



    @Override
    protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().flatMap(RegistryObject::stream);
    }
//    protected java.util.stream.Stream<EntityType<?>> getKnownEntityTypes() {
//        return BuiltInRegistries.ENTITY_TYPE.stream();
//    }
}
