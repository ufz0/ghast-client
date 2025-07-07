package at.ghasty;

import at.ghasty.keybinds.keybinds;
import at.ghasty.screens.TestScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;

public class tickEvents {
    public static void init(){
        ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> {

            while (keybinds.openUI.wasPressed()) {
                Ghastclient.LOGGER.info("Opened UI!");
                if (Ghastclient.client.player != null) {
                    //Ghastclient.client.player.sendMessage(Text.of("Hello World!"), true);
                    Ghastclient.client.setScreen(
                            new TestScreen(Text.empty())
                    );
                }
            }

        });
    }
}
