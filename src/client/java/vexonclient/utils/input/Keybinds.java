package vexonclient.utils.input;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import vexonclient.module.Module;

import java.util.HashMap;
import java.util.Map;

public class Keybinds {
    private static final String CATEGORY = "Vexon Client";
    public static KeyBinding OPEN_GUI = new KeyBinding("key.vexon-client.open-gui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_INSERT, CATEGORY);
    public static KeyBinding OPEN_COMMANDS = new KeyBinding("key.vexon-client.open-commands", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_PERIOD, CATEGORY);
    public static Map<Module, KeyBinding> binds = new HashMap<>();
}