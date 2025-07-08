package at.ghasty.screens;

import at.ghasty.Ghastclient;
import at.ghasty.globals;
import at.ghasty.notifications.ToastNotification;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

import static at.ghasty.globals.showFPS;

public class modMenuScreen extends Screen {
    public modMenuScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {

        ButtonWidget helloWorldButton = ButtonWidget.builder(Text.of("Test Notification"), (btn) -> {
                    ToastNotification.createInfo("Hello World", "Test content");
        }).dimensions(40, 40, 120, 20).build();

        ButtonWidget closeButton = ButtonWidget.builder(Text.of("close"), (btn) -> {
            MinecraftClient.getInstance().setScreen(null);
        }).dimensions(180, 40, 120, 20).build();



        // Register the button widget.
        this.addDrawableChild(helloWorldButton);
        this.addDrawableChild(closeButton);

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        // Minecraft doesn't have a "label" widget, so we'll have to draw our own text.
        // We'll subtract the font height from the Y position to make the text appear above the button.
        // Subtracting an extra 10 pixels will give the text some padding.
        // textRenderer, text, x, y, color, hasShadow
        ButtonWidget toggleFPS = ButtonWidget.builder(Text.of("FPS: "+(showFPS ? "on":"off")), (btn) -> {
            showFPS = !showFPS;
        }).dimensions(320, 40, 120, 20).build();
        this.addDrawableChild(toggleFPS);
        context.drawText(this.textRenderer, "Ghasty Menu", this.width/2, (this.width / 100) * 10 - this.textRenderer.fontHeight - 10, 0xFFFFFFFF, true);
    }
}
