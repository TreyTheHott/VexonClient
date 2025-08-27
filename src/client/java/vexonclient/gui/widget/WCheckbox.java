package vexonclient.gui.widget;

import net.minecraft.client.gui.DrawContext;
import vexonclient.gui.GuiRenderer;
import vexonclient.module.setting.SettingBoolean;

public class WCheckbox extends Widget {
    public final boolean shadow;
    public final SettingBoolean setting;
    private float fillProgress = 0.0f;

    public WCheckbox(int x, int y, int width, int height, int color, String text, boolean shadow, SettingBoolean setting) {
        super(x, y, width, height, color, text);
        this.shadow = shadow;
        this.setting = setting;
    }

    @Override
    public void render(DrawContext context) {
        // --- Checkbox label ---
        GuiRenderer.drawText(context, vec.text, vec.x + 5, vec.y, vec.color, shadow);

        // --- Checkbox background ---
        GuiRenderer.fill(context, vec.x + vec.width + 10, vec.y, 15, 15, 0xFF101010);

        // --- Active animation ---
        float target = setting.getValue() ? 1.0f : 0.0f;
        if (fillProgress < target) fillProgress = Math.min(target, fillProgress + 0.08f);
        else fillProgress = Math.max(target, fillProgress - 0.08f);

        int filledSize = (int)(11 * fillProgress);
        int fillX = vec.x + vec.width + 12 + (11 - filledSize) / 2;
        int fillY = vec.y + 2 + (11 - filledSize) / 2;
        if (filledSize > 0) GuiRenderer.fill(context, fillX, fillY, filledSize, filledSize, 0xFF913DE2);
    }
    @Override
    public void mouseClicked(double mx, double my, int button) {
        if (insideCheckbox(mx, my) && button == 0)
            setting.setValue(!setting.getValue());
    }
    public boolean insideCheckbox(double mx, double my) {
        return mx >= vec.x + vec.width + 10 && mx <= vec.x + vec.width + 25 && my >= vec.y && my <= vec.y + vec.height;
    }
}