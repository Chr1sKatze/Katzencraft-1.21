package net.chriskatze.katzencraft.datagen;

import net.chriskatze.katzencraft.block.ModBlocks;
import net.chriskatze.katzencraft.block.cropblock.CustomAge5CropBlock;
import net.chriskatze.katzencraft.block.cropblock.GerstenBottomCropBlock;
import net.chriskatze.katzencraft.block.cropblock.GerstenTopCropBlock;
import net.chriskatze.katzencraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        // GENERATES STANDARD BLOCK MODELS WITH PROVIDED TEXTURE -------------------------------------------------------
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_END_ORE);

        // GENERATES CROP BLOCK MODELS WITH PROVIDED TEXTURE -----------------------------------------------------------
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP,
                CustomAge5CropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerCrop(ModBlocks.GERSTEN_BOTTOM_CROP,
                GerstenBottomCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.GERSTEN_TOP_CROP,
                GerstenTopCropBlock.AGE, 0, 1, 2);

        // GENERATES POTTED PLANT BLOCK MODELS WITH PROVIDED TEXTURE ---------------------------------------------------
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DAHLIA, ModBlocks.POTTED_DAHLIA,
                BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        // GENERATES STANDARD ITEM MODELS WITH PROVIDED TEXTURE --------------------------------------------------------
        itemModelGenerator.register(ModItems.FLUORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FLUORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
    }
}
