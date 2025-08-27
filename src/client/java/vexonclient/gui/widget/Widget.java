package vexonclient.gui.widget;

import net.minecraft.client.gui.DrawContext;
import vexonclient.utils.WVec;

public abstract class Widget {
    public final WVec vec = new WVec();

    public Widget(int x, int y, int width, int height, int color, String text) {
        vec.x = x;
        vec.y = y;
        vec.width = width;
        vec.height = height;
        vec.color = color;
        vec.text = text;
    }

    public void render(DrawContext context) { }
    public void mouseClicked(double mx, double my, int button) { }
    public void moveY(int dy) {
        vec.y += dy;
    }
    public void setHeight(int height) {
        vec.height = height;
    }
}