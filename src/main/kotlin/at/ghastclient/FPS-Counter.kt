package at.ghastclient

import net.minecraft.client.Minecraft

class FPSCounter {

    fun getFPS(): Int {
        return Minecraft.getInstance().fps
    }
}
