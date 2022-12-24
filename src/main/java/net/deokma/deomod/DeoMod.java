package net.deokma.deomod;

//import net.deokma.deomod.blocks.ModBlocks;
import net.deokma.deomod.item.ModItems;
import net.deokma.deomod.util.ModLootTableModifiers;
import net.deokma.deomod.world.village.VillageAdditions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static net.deokma.deomod.registry.blockRegistry.*;
//import static net.deokma.deomod.registry.itemRegistry.*;
import static net.deokma.deomod.registry.ItemRegistry.registerItems;
import static net.deokma.deomod.sitOnStuff.Sit.sitMain;

public class DeoMod implements ModInitializer {

	// mod info
	public static final String MOD_ID = "deomod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// packet channel for checking if mod loaded
	public static final Identifier LOADED_CHANNEL = new Identifier(MOD_ID, "check_loaded");
	// packet channel for pose requests (keybinds etc.)
	public static final Identifier REQUEST_CHANNEL = new Identifier(MOD_ID, "request_pose");


	@Override
	public void onInitialize() {

		/* Blocks */
		registerChairs();
		//registerItems();

		/* Sit Functions */
		sitMain();

		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
		//ModBlocks.registerModBlocks();
		//ModOreGeneration.generateOres();

		VillageAdditions.registerNewVillageStructures();
		LOGGER.info("DeoMod loaded");
	}
	public static float getModVersion()
	{
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(MOD_ID);

		if(modContainer.isPresent())
		{
			try
			{
				return Float.parseFloat(String.valueOf(modContainer.get().getMetadata().getVersion()));
			}
			catch(NumberFormatException e) {}
		}

		return 0;
	}
}
