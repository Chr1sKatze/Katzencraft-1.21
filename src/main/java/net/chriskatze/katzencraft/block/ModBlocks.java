package net.chriskatze.katzencraft.block;

import net.chriskatze.katzencraft.KatzencraftMod;
import net.chriskatze.katzencraft.block.cropblock.CustomAge5CropBlock;
import net.chriskatze.katzencraft.block.cropblock.GerstenTopCropBlock;
import net.chriskatze.katzencraft.block.cropblock.GerstenBottomCropBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    // STANDARD BLOCKS -------------------------------------------------------------------------------------------------
    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .strength(4f).requiresTool()));

    // ORES ------------------------------------------------------------------------------------------------------------
    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4), AbstractBlock.Settings.copy(Blocks.STONE)
                    .strength(4f).requiresTool()));
    public static final Block FLUORITE_DEEPSLATE_ORE = registerBlock("fluorite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.copy(Blocks.DEEPSLATE)
                    .strength(4f).requiresTool()));
    public static final Block FLUORITE_NETHER_ORE = registerBlock("fluorite_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4), AbstractBlock.Settings.copy(Blocks.NETHERRACK)
                    .strength(4f).requiresTool()));
    public static final Block FLUORITE_END_ORE = registerBlock("fluorite_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4), AbstractBlock.Settings.copy(Blocks.END_STONE)
                    .strength(4f).requiresTool()));

    // CROPS -----------------------------------------------------------------------------------------------------------
    public static final CropBlock STRAWBERRY_CROP = registerCropBlockSimple("strawberry_crop");

    public static final Block GERSTEN_BOTTOM_CROP = registerBlockWithoutBlockItem("gersten_bottom_crop",
            new GerstenBottomCropBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block GERSTEN_TOP_CROP = registerBlockWithoutBlockItem("gersten_top_crop",
            new GerstenTopCropBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    // FLOWERS ---------------------------------------------------------------------------------------------------------
    public static final Block DAHLIA = registerBlock("dahlia",
            new FlowerBlock(StatusEffects.LUCK, 7, AbstractBlock.Settings.copy(Blocks.DANDELION)));

    // POTTED FLOWERS --------------------------------------------------------------------------------------------------
    public static final Block POTTED_DAHLIA = registerBlockWithoutBlockItem("potted_dahlia",
            new FlowerPotBlock(DAHLIA, AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION).nonOpaque()));

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    // USED TO REGISTER BLOCKS WITHOUT ASSOCIATED BLOCK ITEMS (BLOCK = ITEM) -------------------------------------------
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(KatzencraftMod.MOD_ID, name), block);
    }

    // USED TO REGISTER STANDARD BLOCKS --------------------------------------------------------------------------------
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(KatzencraftMod.MOD_ID, name), block);
    }

    // USED TO REGISTER THE ASSOCIATED BLOCK ITEM (BLOCK =/= BLOCKITEM) ------------------------------------------------
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(KatzencraftMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // USED TO REGISTER STANDARD BEHAVIOURAL CROPBLOCKS (1 BLOCK TALL) -------------------------------------------------
    private static CropBlock registerCropBlockSimple(String name) {
        return Registry.register(Registries.BLOCK, Identifier.of(KatzencraftMod.MOD_ID, name),
                new CustomAge5CropBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                        .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
                        .pistonBehavior(PistonBehavior.DESTROY), name));
    }

    // USED FOR INITIALIZATION AND LOGGING OF MODBLOCKS ----------------------------------------------------------------
    public static void registerModBlocks() {
        KatzencraftMod.LOGGER.info("Registering Mod Blocks for " + KatzencraftMod.MOD_ID);
    }
}