package vexonclient;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vexonclient.events.EventBus;

public class VexonClient implements ClientModInitializer {
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static final Logger LOGGER = LoggerFactory.getLogger("VexonClient");
	public static final EventBus EVENT_BUS = new EventBus();

	@Override
	public void onInitializeClient() {
		LOGGER.info("Vexon Client Started!");
	}
}