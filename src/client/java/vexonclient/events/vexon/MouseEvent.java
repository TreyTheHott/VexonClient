package vexonclient.events.vexon;

import vexonclient.events.Event;

/**
 * Represents a mouse event.
 * Fired whenever the mouse is clicked.
 */
public class MouseEvent extends Event {
    private final int button, action, x, y;

    public MouseEvent(int button, int action, double x, double y) {
        this.button = button;
        this.action = action;
        this.x = (int)x;
        this.y = (int)y;
    }

    public int getButton() {
        return button;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean isPressed() {
        return action == 1;
    }
    public boolean isReleased() {
        return action == 0;
    }
}