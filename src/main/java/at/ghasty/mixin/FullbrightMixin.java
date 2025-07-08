package at.ghasty.mixin;

import at.ghasty.globals;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapTextureManager.class)
public class FullbrightMixin {

	@Inject(method = "update", at = @At("HEAD"), cancellable = true)
	private void onUpdate(float delta, CallbackInfo ci) {
		// Cancel the default lightmap update — prevents lighting changes
//		if (globals.fullbright){
//			ci.cancel();
//		}
			ci.cancel();
	}
}
