import net.minecraft.client.Minecraft
import net.minecraft.client.player.LocalPlayer

class Coordinates {

    fun getPlayerCoordinates(): Triple<Double, Double, Double>? {
        val player: LocalPlayer? = Minecraft.getInstance().player
        return if (player != null) {
            Triple(player.x, player.y, player.z)
        } else {
            null // Player is not loaded yet
        }
    }
}
