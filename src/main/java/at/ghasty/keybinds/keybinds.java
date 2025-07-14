package at.ghasty.keybinds;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class keybinds {
    public static KeyBinding openModMenu;
    public static final String CATEGORY = "Ghasty";

    public static void init() {
        openModMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.ghasty.openMenu",
                InputUtil.Type.KEYSYM, // Type (KEYSYM = keyboard, MOUSE = mouse button)
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                CATEGORY
        ));
    }
}
