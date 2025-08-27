package vexonclient.gui;

import net.minecraft.client.gui.DrawContext;
import vexonclient.gui.screens.ModuleScreen;
import vexonclient.module.Module;
import vexonclient.utils.WVec;

import static vexonclient.VexonClient.mc;

public class ModuleButton {
    private float activeProgress = 0.0f;
    private float hoverProgress = 0.0f;
    private final Module module;
    private final WVec vec;

    public ModuleButton(Module module, int x, int y) {
        this.module = module;
        vec = new WVec(x, y, 150, 23);
    }

    public void render(DrawContext context) {
        GuiRenderer.fill(context, vec.x, vec.y, vec.width, vec.height, module.isActive() ? 0xFF323232 : 0xC8141414); // background

        // hover background animation
        if (module.isActive()) hoverProgress = 1.0f;
        else hoverProgress = (insideButton(mc.mouse.getX(), mc.mouse.getY())) ? Math.min(1.0f, hoverProgress + 0.04f) : Math.max(0.0f, hoverProgress - 0.04f);
        GuiRenderer.fill(context, vec.x, vec.y, (int)(vec.width * hoverProgress), vec.height, 0xFF424242);

        // active bar animation
        float activeTarget = module.isActive() ? 1.0f : 0.0f;
        activeProgress = (activeProgress < activeTarget) ? (Math.min(activeTarget, activeProgress + 0.075f)) : Math.max(activeTarget, activeProgress - 0.075f);
        int indicatorH = (int)(vec.height * activeProgress);
        if (activeProgress > 0) GuiRenderer.fill(context, vec.x, vec.y + vec.height - indicatorH, 2, indicatorH, 0xFF913DE2);

        //GuiRenderer.drawTextCentered(context, module.getName(), vec.x, vec.y + 2, vec.width, vec.height, 0xFFFFFFFF, false); // add sorting options (centered, left, right)
        GuiRenderer.drawText(context, module.getName(), vec.x + 5, vec.y + 5, 0xFFFFFFFF, false);
    }
    public void mouseClicked(double mx, double my, int button) {
        if (insideButton(mx, my)) {
            if (button == 0) module.toggleActive();
            else if (button == 1) mc.setScreen(new ModuleScreen(module));
        }
    }
    public boolean insideButton(double mx, double my) {
        return mx >= vec.x && mx <= vec.x + vec.width && my >= vec.y + 1 && my <= vec.y + vec.height;
    }
}