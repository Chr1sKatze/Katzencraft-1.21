package net.chriskatze.katzencraft.item;

import net.chriskatze.katzencraft.KatzencraftMod;
import net.chriskatze.katzencraft.block.ModBlocks;
import net.chriskatze.katzencraft.entity.ModEntities;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // ORES ------------------------------------------------------------------------------------------------------------
    public static final Item FLUORITE = registerItem("fluorite", new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", new Item(new Item.Settings()));

    // CROP PRODUCE ----------------------------------------------------------------------------------------------------
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings()
            .food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 1.0f)
                    .snack().build())));

    // CROP SEEDS ------------------------------------------------------------------------------------------------------
    public static final Item STRAWBERRY_SEEDS = registerItem("strawberry_seeds",
            new AliasedBlockItem(ModBlocks.STRAWBERRY_CROP, new Item.Settings()));
    public static final Item GERSTEN_SEEDS = registerItem("gersten_seeds",
            new AliasedBlockItem(ModBlocks.GERSTEN_BOTTOM_CROP, new Item.Settings()));
    public static final Item GERSTEN_TOP_SEEDS = registerItem("gersten_top_seeds",
            new AliasedBlockItem(ModBlocks.GERSTEN_TOP_CROP, new Item.Settings()));

    // SPAWN EGGS ------------------------------------------------------------------------------------------------------
    public static final Item BULBASAUR_SPAWN_EGG = registerItem("bulbasaur_spawn_egg",
            new SpawnEggItem(ModEntities.BULBASAUR, 0x465ae0,0x545978, new Item.Settings()));
    public static final Item IVYSAUR_SPAWN_EGG = registerItem("ivysaur_spawn_egg",
            new SpawnEggItem(ModEntities.IVYSAUR, 0x465ae0,0x545978, new Item.Settings()));

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    // USED TO REGISTER STANDARD ITEMS ---------------------------------------------------------------------------------
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(KatzencraftMod.MOD_ID, name), item);
    }

    // USED FOR INITIALIZATION AND LOGGING OF MODITEMS -----------------------------------------------------------------
    public static void registerModItems() {
        KatzencraftMod.LOGGER.info("Registering ModItems for " + KatzencraftMod.MOD_ID);
    }
}