package net.chriskatze.katzencraft.block;

import net.chriskatze.katzencraft.KatzencraftMod;
import net.chriskatze.katzencraft.block.custom.GerstenTopCropBlock;
import net.chriskatze.katzencraft.block.custom.StrawberryCropBlock;
import net.chriskatze.katzencraft.block.custom.GerstenBottomCropBlock;
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

    // list of mod blocks
    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .strength(4f).requiresTool()));
    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4), AbstractBlock.Settings.create()
                            .strength(4f).requiresTool()));
    public static final Block FLUORITE_DEEPSLATE_ORE = registerBlock("fluorite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.create()
                            .strength(4f).requiresTool()));
    public static final Block FLUORITE_NETHER_ORE = registerBlock("fluorite_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4), AbstractBlock.Settings.create()
                            .strength(4f).requiresTool()));
    public static final Block FLUORITE_END_ORE = registerBlock("fluorite_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4), AbstractBlock.Settings.create()
                            .strength(4f).requiresTool()));
    // list of crop blocks
    public static final Block STRAWBERRY_CROP = registerBlockWithoutBlockItem("strawberry_crop",
            new StrawberryCropBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

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

    // list of flowers
    public static final Block DAHLIA = registerBlock("dahlia",
            new FlowerBlock(StatusEffects.INVISIBILITY, 4, AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    // list of potted flowers
    public static final Block POTTED_DAHLIA = registerBlockWithoutBlockItem("potted_dahlia",
            new FlowerPotBlock(DAHLIA, AbstractBlock.Settings.create()
                    .breakInstantly()
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    // used for blocks without associated block items
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(KatzencraftMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(KatzencraftMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(KatzencraftMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // registers and logs the mod blocks
    public static void registerModBlocks() {
        KatzencraftMod.LOGGER.info("Registering Mod Blocks for " + KatzencraftMod.MOD_ID);
    }
}
