package vexonclient.mixins;

import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vexonclient.VexonClient;
import vexonclient.events.vexon.MouseEvent;

@Mixin(Mouse.class)
public class MouseMixin {
    /**
     * Fires MouseEvent
     */
    @Inject(method = "onMouseButton", at = @At("HEAD"), cancellable = true)
    private void onMouseButtonPre(long window, int button, int action, int mods, CallbackInfo ci) {
        MouseEvent event = new MouseEvent(button, action, VexonClient.mc.mouse.getX(), VexonClient.mc.mouse.getY());
        if (VexonClient.EVENT_BUS.post(event).isCancelled()) ci.cancel();
    }
}