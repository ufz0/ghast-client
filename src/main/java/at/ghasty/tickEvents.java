package at.ghasty;

import at.ghasty.keybinds.keybinds;
import at.ghasty.utils.ToastNotification;
import at.ghasty.screens.modMenuScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;

public class tickEvents {
    public static boolean shownInfo = false;
    public static boolean toastShown = false;

    public static void init(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.currentScreen instanceof TitleScreen && !toastShown) {
                at.ghasty.utils.ToastNotification.createInfo("Startup complete!", "Welcome to Ghasty!");
                toastShown = true;
            }
        });
        ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> {

            if (globals.showFPS && Ghastclient.client.player != null){
                int fps = MinecraftClient.getInstance().getCurrentFps();
                String info = String.format("FPS: %s", fps);
                MinecraftClient.getInstance().player.sendMessage(Text.of(info), true);
            }

            while (keybinds.openUI.wasPressed()) {
                Ghastclient.LOGGER.info("Opened UI!");
                if (Ghastclient.client.player != null) {
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
