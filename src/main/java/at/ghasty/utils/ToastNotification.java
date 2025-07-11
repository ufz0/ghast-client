package at.ghasty.utils;


import at.ghasty.Ghastclient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class ToastNotification {
    public static void createInfo(String title, String content){
        Ghastclient.client.getToastManager().add(
            SystemToast.create(Ghastclient.client, SystemToast.Type.CHUNK_SAVE_FAILURE, Text.of(title), Text.of(content))
        );

    }
}
