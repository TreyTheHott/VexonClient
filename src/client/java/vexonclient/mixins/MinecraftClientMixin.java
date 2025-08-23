package vexonclient.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vexonclient.VexonClient;
import vexonclient.events.game.GameLeftEvent;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "disconnect", at = @At("HEAD"))
    private void onDisconnect(Screen disconnectionScreen, boolean transferring, CallbackInfo ci) {
        VexonClient.EVENT_BUS.post(new GameLeftEvent());
    }
}