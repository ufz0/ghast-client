package at.ghasty;

import at.ghasty.keybinds.keybinds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ghastclient implements ModInitializer {
	public static final String MOD_ID = "ghast-client";
	public static MinecraftClient client = MinecraftClient.getInstance();
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//Register all commands
		at.ghasty.utils.commands.registerCommands();
		// Register keybindings
		keybinds.init();
		// Start tick events
		tickEvents.init();



		LOGGER.info("Ghasty initialized");
	}
}