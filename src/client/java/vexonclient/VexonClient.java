package vexonclient;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vexonclient.events.EventBus;
import vexonclient.events.EventListener;
import vexonclient.events.vexon.KeyEvent;
import vexonclient.gui.GuiScreen;
import vexonclient.utils.input.KeyAction;
import vexonclient.utils.input.Keybinds;

public class VexonClient implements ClientModInitializer {
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static final Logger LOGGER = LoggerFactory.getLogger("VexonClient");
	public static final EventBus EVENT_BUS = new EventBus();

	@Override
	public void onInitializeClient() {
		LOGGER.info("Vexon Client Started!");
		EVENT_BUS.register(this);
	}

	@EventListener
	private void keyListener(KeyEvent event) {
		int key = event.getKey(), scancode = event.getScancode();
		if (Keybinds.OPEN_GUI.matchesKey(key, scancode) && event.getAction() == KeyAction.Press)
			GuiScreen.INSTANCE.setOpen(!GuiScreen.INSTANCE.isOpen());
	}
}