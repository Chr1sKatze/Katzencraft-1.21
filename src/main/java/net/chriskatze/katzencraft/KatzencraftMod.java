package net.chriskatze.katzencraft;

import net.chriskatze.katzencraft.block.ModBlocks;
import net.chriskatze.katzencraft.item.ModItemGroups;
import net.chriskatze.katzencraft.item.ModItems;
import net.chriskatze.katzencraft.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.ComposterBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KatzencraftMod implements ModInitializer {
	public static final String MOD_ID = "katzencraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		// THIS CODE RUNS AS SOON AS MINECRAFT IS IN A MOD-LOAD-READY STATE --------------------------------------------
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGeneration();

		// USED TO ADD ITEMS TO THE COMPOSTER --------------------------------------------------------------------------
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STRAWBERRY, 0.3f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STRAWBERRY_SEEDS, 0.2f);
	}
}