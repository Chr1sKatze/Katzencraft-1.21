package net.chriskatze.katzencraft.datagen;

import net.chriskatze.katzencraft.block.ModBlocks;
import net.chriskatze.katzencraft.block.custom.StrawberryCropBlock;
import net.chriskatze.katzencraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // normal self drops
        addDrop(ModBlocks.FLUORITE_BLOCK);
        addDrop(ModBlocks.DAHLIA);

        // flower pot drops
        addDrop(ModBlocks.POTTED_DAHLIA, pottedPlantDrops(ModBlocks.DAHLIA));

        // ore drops
        addDrop(ModBlocks.FLUORITE_ORE, oreDrops(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE));
        addDrop(ModBlocks.FLUORITE_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE, 2, 5));
        addDrop(ModBlocks.FLUORITE_NETHER_ORE, oreDrops(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE));
        addDrop(ModBlocks.FLUORITE_END_ORE, oreDrops(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE));

        // crop block drops
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(StrawberryCropBlock.AGE, 5));
        this.addDrop(ModBlocks.STRAWBERRY_CROP, this.cropDrops(ModBlocks.STRAWBERRY_CROP, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS, builder));
    }

    // function for multuple ore drops
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
