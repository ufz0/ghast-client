package at.ghasty.screens;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.impl.client.rendering.hud.HudLayer;
import net.minecraft.util.Identifier;

public class hudLayerTest implements HudLayer {
    //private final Identifier ID = new Identifier("ghast-client", "hello_world");    <-- Causing issues, "Identifier" throws an error
    private final HudElement ELEMENT = new hudRenderTest();
    @Override
    public Identifier id() {
        return null;
    }

    @Override
    public HudElement element(HudElement hudElement) {
        return ELEMENT;
    }

    @Override
    public boolean isRemoved() {
        return false;
    }
}
