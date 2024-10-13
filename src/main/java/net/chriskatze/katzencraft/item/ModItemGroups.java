package net.chriskatze.katzencraft.item;

import net.chriskatze.katzencraft.KatzencraftMod;
import net.chriskatze.katzencraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    // ADDS ITEMS INTO THE FLUORITE ITEM ITEMGROUP ---------------------------------------------------------------------
    public static final ItemGroup  FLUORITE_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KatzencraftMod.MOD_ID, "fluorite_item"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite_item"))
                    .icon(() -> new ItemStack(ModItems.FLUORITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FLUORITE);
                        entries.add(ModItems.RAW_FLUORITE);}).build());

    // ADDS ITEMS INTO THE FLUORITE BLOCK ITEMGROUP --------------------------------------------------------------------
    public static final ItemGroup  FLUORITE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KatzencraftMod.MOD_ID, "fluorite_block"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite_block"))
                    .icon(() -> new ItemStack(ModBlocks.FLUORITE_ORE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FLUORITE_ORE);
                        entries.add(ModBlocks.FLUORITE_DEEPSLATE_ORE);
                        entries.add(ModBlocks.FLUORITE_NETHER_ORE);
                        entries.add(ModBlocks.FLUORITE_END_ORE);
                        entries.add(ModBlocks.FLUORITE_BLOCK);}).build());

    // ADDS ITEMS INTO THE CORRESPONDING VANILLA CREATIVE TAB GROUPS ---------------------------------------------------
    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(ModItems.FLUORITE);
        entries.add(ModItems.RAW_FLUORITE);
    }

    private static void customFood_And_Drink(FabricItemGroupEntries entries) {
        entries.add(ModItems.STRAWBERRY);
        entries.add(ModItems.STRAWBERRY_SEEDS);
        entries.add(ModItems.GERSTEN_SEEDS);
    }

    private static void customNatural(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.DAHLIA);
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    // USED FOR INITIALIZATION AND LOGGING OF MODITEMGROUPS ------------------------------------------------------------
    public static void registerItemGroups() {
        KatzencraftMod.LOGGER.info("Registering Item Groups for " + KatzencraftMod.MOD_ID);

        // USED TO MODIFY THE VANILLA CREATIVE TAB ENTRIES -------------------------------------------------------------
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItemGroups::customIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItemGroups::customFood_And_Drink);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItemGroups::customNatural);
    }
}