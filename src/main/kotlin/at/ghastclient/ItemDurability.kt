package at.ghastclient

import net.minecraft.client.Minecraft
import net.minecraft.world.item.ItemStack

class ItemDurability {

    fun getDur(): String {
        val player = Minecraft.getInstance().player ?: return "No player"
        val itemStack: ItemStack = player.mainHandItem

        if (itemStack.isEmpty) {
            return "No item in hand"
        }

        val maxDurability = itemStack.maxDamage
        val currentDamage = itemStack.damageValue
        val remainingDurability = maxDurability - currentDamage

        return "Durability: $remainingDurability / $maxDurability"
    }
}
