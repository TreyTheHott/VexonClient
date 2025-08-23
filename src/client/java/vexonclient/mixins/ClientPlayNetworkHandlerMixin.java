package vexonclient.mixins;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vexonclient.VexonClient;
import vexonclient.events.game.GameJoinedEvent;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    /**
     * Fires GameJoinedEvent
     */
    @Inject(method = "onGameJoin", at = @At("HEAD"))
    private void onGameJoinPre(GameJoinS2CPacket packet, CallbackInfo ci) {
        VexonClient.EVENT_BUS.post(new GameJoinedEvent());
    }
}