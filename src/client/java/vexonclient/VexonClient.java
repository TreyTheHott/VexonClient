package vexonclient;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VexonClient implements ClientModInitializer {
	// ==================== VARIABLES ==================== \\
	public static final Logger LOGGER = LoggerFactory.getLogger("VexonClient");

	// ==================== METHODS ==================== \\
	@Override
	public void onInitializeClient() {
		LOGGER.info("Vexon Client Started!");
	}
}