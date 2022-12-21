package net.deokma.deomod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.deokma.deomod.config.ConfigManager;
import net.deokma.deomod.entity.ChairEntity;
import net.deokma.deomod.entity.PoseManagerEntity;
import net.deokma.deomod.error.LoadConfigException;
import net.deokma.deomod.util.Commands;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.entity.*;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static net.deokma.deomod.registry.blockRegistry.*;
import static net.deokma.deomod.registry.fuelRegistry.registerFuel;
import static net.deokma.deomod.registry.recipeRegistry.registerRecipes;
import static net.deokma.deomod.registry.screenRegistry.registerScreens;
import static net.deokma.deomod.sitOnStuff.Sit.sitMain;

public class DeoMod implements ModInitializer {

	// mod info
	public static final String MOD_ID = "deomod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Pose manager and chair entities
	public static final EntityType<PoseManagerEntity> RAW_CHAIR_ENTITY_TYPE = PoseManagerEntity.register();
	public static final EntityType<ChairEntity> CHAIR_ENTITY_TYPE = ChairEntity.register();

	// packet channel for checking if mod loaded
	public static final Identifier LOADED_CHANNEL = new Identifier(MOD_ID, "check_loaded");
	// packet channel for pose requests (keybinds etc.)
	public static final Identifier REQUEST_CHANNEL = new Identifier(MOD_ID, "request_pose");


	@Override
	public void onInitialize() {
		Commands.register();
		registerWorkBench();

		/* Blocks */
		registerBenches();
		registerChairs();
		registerStools();
		registerTables();

		registerBlockEntities();

		/* Items */
		//registerItems();

		/* Fuel */
		registerFuel();

		/* Recipes */
		registerRecipes();

		/* Screens */
		registerScreens();

		/* Sit Functions */
		sitMain();
		FabricDefaultAttributeRegistry.register(RAW_CHAIR_ENTITY_TYPE, ArmorStandEntity.createLivingAttributes());

		try {
			ConfigManager.loadConfig();
		} catch(LoadConfigException ignored) {
			LOGGER.warn("DeoMod config not loaded! Using default settings");
		}

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
