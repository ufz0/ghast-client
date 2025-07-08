package at.ghasty;

import at.ghasty.keybinds.keybinds;
import at.ghasty.screens.modMenuScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static at.ghasty.globals.showFPS;

public class tickEvents {
    public static void init(){
        ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> {

            if (showFPS && Ghastclient.client.player != null){
                int fps = MinecraftClient.getInstance().getCurrentFps();
                String info = String.format("FPS: %s", fps);
                MinecraftClient.getInstance().player.sendMessage(Text.of(info), true);
            }

            while (keybinds.openUI.wasPressed()) {
                Ghastclient.LOGGER.info("Opened UI!");
                if (Ghastclient.client.player != null) {
                    //Ghastclient.client.player.sendMessage(Text.of("Hello World!"), true);
                    Ghastclient.client.setScreen(
                            new modMenuScreen(Text.empty())
                    );
                }
            }

        });
    }
}
