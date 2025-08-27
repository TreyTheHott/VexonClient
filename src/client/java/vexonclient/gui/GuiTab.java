package vexonclient.gui;

import net.minecraft.client.gui.DrawContext;
import vexonclient.module.Module;
import vexonclient.utils.Category;
import vexonclient.utils.WVec;

import java.util.ArrayList;
import java.util.List;

public class GuiTab {
    private final List<ModuleButton> buttons = new ArrayList<>();
    private final Category category;
    private final WVec vec;

    public GuiTab(Category category, int x, int y) {
        this.category = category;
        this.vec = new WVec(x, y, 150, 29);
    }

    public void render(DrawContext context) {
        if (!GuiScreen.INSTANCE.isOpen()) return;

        GuiRenderer.fill(context, vec.x, vec.y, vec.width, vec.height, 0xFF913DE2); // background
        GuiRenderer.drawTextHeaderCentered(context, category.name(), vec.x, vec.y + 4, vec.width, vec.height, 0xFFFFFFFF, false);

        for (ModuleButton mbutton : buttons) mbutton.render(context);
    }
    public void mouseClicked(double mx, double my, int button) {
        for (ModuleButton mbutton : buttons) mbutton.mouseClicked(mx, my, button);
    }
}