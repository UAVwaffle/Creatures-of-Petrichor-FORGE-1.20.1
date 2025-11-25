package com.uavwaffle.creaturesofpetrichor.datagen;

import com.uavwaffle.creaturesofpetrichor.CreaturesOfPetrichor;
import com.uavwaffle.creaturesofpetrichor.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator  extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreaturesOfPetrichor.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
//        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
//                .add(ModBlocks.ALEXANDRITE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get(),
                        ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),
                        ModBlocks.FORGOTTEN_GRAVESTONE_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get(),
                        ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

//        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
//                        ModBlocks.END_STONE_ALEXANDRITE_ORE.get(),
//                        ModBlocks.NETHER_ALEXANDRITE_ORE.get());
    }

    @Override
    public @NotNull String getName() {
        return "Block Tags";
    }
}
