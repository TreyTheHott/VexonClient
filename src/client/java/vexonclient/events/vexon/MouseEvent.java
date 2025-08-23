package vexonclient.events.vexon;

import vexonclient.events.Event;

/**
 * Represents a mouse event.
 * Fired whenever the mouse is clicked or moved.
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
    public int getAction() {
        return action;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean isLeftClick() {
        return button == 0 && action == 1;
    }
    public boolean isRightClick() {
        return button == 1 && action == 1;
    }
    public boolean isMiddleClick() {
        return button == 2 && action == 1;
    }
    public boolean isReleased() {
        return action == 0;
    }
}