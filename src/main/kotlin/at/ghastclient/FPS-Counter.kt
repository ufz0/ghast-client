package at.ghastclient

import net.minecraft.client.Minecraft

object FPSCounter {
    fun getFPS(): Int {
        return Minecraft.getInstance().fps
    }
}
