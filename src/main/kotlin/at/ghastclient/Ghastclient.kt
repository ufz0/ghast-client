package at.ghastclient

import net.fabricmc.api.ModInitializer
import net.minecraft.client.Minecraft
import org.slf4j.LoggerFactory

object Ghastclient : ModInitializer {
    private val logger = LoggerFactory.getLogger("ghast-client")

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
		val client = Minecraft.getInstance()

		while(true){
			if(client.isGameLoadFinished){
				logger.info("${FPSCounter.getFPS()}")
			}
		}
	}
}