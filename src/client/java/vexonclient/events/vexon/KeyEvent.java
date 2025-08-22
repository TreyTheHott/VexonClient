package vexonclient.events.vexon;

import org.lwjgl.glfw.GLFW;
import vexonclient.events.Event;

/**
 * Represents a keyboard input event.
 * Fired whenever a key is pressed or released.
 */
public class KeyEvent extends Event {
    private final int key, scancode, action, modifiers;

    public KeyEvent(int key, int scancode, int action, int modifiers) {
        this.key = key;
        this.scancode = scancode;
        this.action = action;
        this.modifiers = modifiers;
    }

    public int getKey() {
        return key;
    }
    public int getScancode() {
        return scancode;
    }
    public int getAction() {
        return action;
    }
    public int getModifiers() {
        return modifiers;
    }
    public boolean isPressed() {
        return action == GLFW.GLFW_PRESS;
    }
}