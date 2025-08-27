package vexonclient.gui.widget;

import net.minecraft.client.gui.DrawContext;
import vexonclient.gui.GuiRenderer;

public class WRect extends Widget {
    public WRect(int x, int y, int width, int height, int color) {
        super(x, y, width, height, color, "");
    }

    @Override
    public void render(DrawContext context) {
        GuiRenderer.fill(context, vec.x, vec.y, vec.width, vec.height, vec.color);
    }
}