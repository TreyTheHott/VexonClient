package vexonclient.events.vexon;

import vexonclient.events.Event;
import vexonclient.utils.input.KeyAction;

/**
 * Represents a keyboard input event.
 * Fired whenever a key is pressed or released.
 */
public class KeyEvent extends Event {
    private final int key, scancode, modifiers;
    private final KeyAction action;

    public KeyEvent(int key, int scancode, int action, int modifiers) {
        this.key = key;
        this.scancode = scancode;
        this.modifiers = modifiers;
        this.action = KeyAction.get(action);
    }

    public int getKey() {
        return key;
    }
    public int getScancode() {
        return scancode;
    }
    public int getModifiers() {
        return modifiers;
    }
    public KeyAction getAction() {
        return action;
    }
}