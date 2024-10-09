package net.chriskatze.katzencraft.item;

import net.chriskatze.katzencraft.KatzencraftMod;
import net.chriskatze.katzencraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    // adds a creative inventory Itemgroup
    public static final ItemGroup  FLUORITE_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KatzencraftMod.MOD_ID, "fluorite_item"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite_item"))
                    .icon(() -> new ItemStack(ModItems.FLUORITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FLUORITE);
                        entries.add(ModItems.RAW_FLUORITE);
                    }).build());

    // adds a creative inventory Itemgroup
    public static final ItemGroup  FLUORITE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KatzencraftMod.MOD_ID, "fluorite_block"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite_block"))
                    .icon(() -> new ItemStack(ModBlocks.FLUORITE_ORE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FLUORITE_ORE);
                        entries.add(ModBlocks.FLUORITE_DEEPSLATE_ORE);
                        entries.add(ModBlocks.FLUORITE_NETHER_ORE);
                        entries.add(ModBlocks.FLUORITE_END_ORE);
                        entries.add(ModBlocks.FLUORITE_BLOCK);
                    }).build());

    // registers and logs the Itemgroups
    public static void registerItemGroups() {
        KatzencraftMod.LOGGER.info("Registering Item Groups for " + KatzencraftMod.MOD_ID);
    }
}