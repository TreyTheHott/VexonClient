package vexonclient.gui.widget;

import net.minecraft.client.gui.DrawContext;
import vexonclient.gui.GuiRenderer;

public class WTextCentered extends WText {
    public final int width, height;

    public WTextCentered(int x, int y, int width, int height, int color, String text, boolean shadow) {
        super(x, y, color, text, shadow);
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(DrawContext context) {
        GuiRenderer.drawTextCentered(context, vec.text, vec.x, vec.y, width, height, vec.color, shadow);
    }
}