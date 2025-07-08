package at.ghasty;

import at.ghasty.keybinds.keybinds;
import at.ghasty.notifications.ToastNotification;
import at.ghasty.screens.modMenuScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.Toast;
import net.minecraft.text.Text;
import at.ghasty.globals;

import java.util.Optional;

public class tickEvents {
    public static boolean shownInfo = false;

    public static void init(){

        ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> {

            if (globals.showFPS && Ghastclient.client.player != null){
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
            if (!shownInfo && Ghastclient.client.isFinishedLoading() && Ghastclient.client.player != null){
                ToastNotification.createInfo("WIP", "Ghasty is work in progress, nothing is finished.");
                shownInfo = true;
            }
        });
    }
}
