package vexonclient.mixins;

import net.minecraft.client.Keyboard;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vexonclient.VexonClient;
import vexonclient.events.vexon.KeyEvent;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    private void onKeyPre(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        if (key == GLFW.GLFW_KEY_UNKNOWN || key == GLFW.GLFW_REPEAT) return;

        if (VexonClient.EVENT_BUS.post(new KeyEvent(key, scancode, action, modifiers)).isCancelled()) ci.cancel();
    }
}