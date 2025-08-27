package vexonclient.gui.widget;

import net.minecraft.client.gui.DrawContext;
import vexonclient.gui.GuiRenderer;

public class WText extends Widget {
    public final boolean shadow;

    public WText(int x, int y, int color, String text, boolean shadow) {
        super(x, y, 0, 0, color, text);
        this.shadow = shadow;
    }

    @Override
    public void render(DrawContext context) {
        GuiRenderer.drawText(context, vec.text, vec.x, vec.y, vec.color, shadow);
    }
}