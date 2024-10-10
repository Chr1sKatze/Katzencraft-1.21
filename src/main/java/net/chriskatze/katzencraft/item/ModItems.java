package net.chriskatze.katzencraft.item;

import net.chriskatze.katzencraft.KatzencraftMod;
import net.chriskatze.katzencraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.CropBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(KatzencraftMod.MOD_ID, name), item);
    }
    // list of mod items
    public static final Item FLUORITE = registerItem("fluorite", new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", new Item(new Item.Settings()));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)));
    public static final Item STRAWBERRY_SEEDS = registerItem("strawberry_seeds", new AliasedBlockItem(ModBlocks.STRAWBERRY_CROP, new Item.Settings()));

    // puts items in the vanilla "ingredients" creative inventory itemgroup
    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(FLUORITE);
        entries.add(RAW_FLUORITE);
    }

    // puts items in the vanilla "Food And Drink" creative inventory itemgroup
    private static void customFood_And_Drink(FabricItemGroupEntries entries) {
        entries.add(STRAWBERRY);
        entries.add(STRAWBERRY_SEEDS);
    }

    // puts items in the vanilla "Natural" creative inventory itemgroup
    private static void customNatural(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.DAHLIA);
    }

    // registers and logs the mod items
    public static void registerModItems() {
        KatzencraftMod.LOGGER.info("Registering ModItems for " + KatzencraftMod.MOD_ID);

    // puts items in the vanilla "Ingredients" creative inventory itemgroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    // puts items in the vanilla "Food_And_Drink" creative inventory itemgroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::customFood_And_Drink);
        // puts items in the vanilla "Food_And_Drink" creative inventory itemgroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::customNatural);
    }
}