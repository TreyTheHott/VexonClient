package vexonclient.gui.screens;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import vexonclient.gui.GuiScreen;
import vexonclient.gui.widget.*;
import vexonclient.module.Module;
import vexonclient.module.ModuleCategory;
import vexonclient.module.setting.Setting;
import vexonclient.module.setting.SettingBoolean;
import vexonclient.module.setting.SettingNumber;

import java.util.ArrayList;
import java.util.List;

import static vexonclient.VexonClient.mc;

public class ModuleScreen extends Screen {
    private final List<Widget> widgets = new ArrayList<>();

    public ModuleScreen(Module module) {
        super(Text.literal(""));

        // -------------------- WIDGET LOGIC -------------------- \\
        int tabW = Math.max(500, (int)(mc.textRenderer.getWidth(module.getDescription()) * 1.85f) + 20);
        int tabX = (mc.getWindow().getWidth() - tabW) / 2;
        int curY = 0;

        // --- Header ---
        widgets.add(new WRect(tabX, curY, tabW, 29, 0xFF913DE2));
        widgets.add(new WTextHeaderCentered(tabX, curY + 2, tabW, 29, 0xFFFFFFFF, module.getName(), false));
        curY += 29;

        // --- Background ---
        WRect background = new WRect(tabX, curY, tabW, 0, 0xB0101010);
        widgets.add(background);

        // --- Description ---
        widgets.add(new WText(tabX + 10, curY + 6, 0xFFFFFFFF, module.getDescription(), false));
        curY += 25;

        // --- Categories + Settings ---
        for (ModuleCategory category : module.getCategories()) {
            int sepY = curY + 15;
            int sepW = (int)(mc.textRenderer.getWidth(category.getName()) * 1.85f);

            if (category.getName().isEmpty()) {
                widgets.add(new WRect(tabX + 10, sepY, tabW - 20, 1, 0xFFFFFFFF));
            }
            else {
                widgets.add(new WTextCentered(tabX + 10, sepY, tabW - 20, 1, 0xFFFFFFFF, category.getName(), false));
                widgets.add(new WRect(tabX + 10, sepY, (tabW - sepW) / 2 - 19, 1, 0xFFFFFFFF));
                widgets.add(new WRect(tabX + 5 + (tabW + sepW) / 2, sepY, (tabW - sepW) / 2 - 20, 1, 0xFFFFFFFF));
            }

            int settingY = sepY + 15;
            for (Setting<?> setting : category.getSettings()) {
                int settingW = (int)(mc.textRenderer.getWidth(setting.getName()) * 1.85f);
                switch (setting) {
                    case SettingBoolean booleanSetting -> {
                        widgets.add(new WCheckbox(tabX + 10, settingY, settingW, 15, 0xFFFFFFFF, setting.getName(), false, booleanSetting));
                        settingY += 25;
                    }
                    case SettingNumber numberSetting -> {
                        widgets.add(new WText(tabX + 10, settingY, 0xFFFFFFFF, setting.getName(), false));
                        settingY += 25;
                    }
                    default -> {
                    }
                }
            }
            curY = settingY - 14;
        }
        curY -= 15;

        // --- Finalize background height ---
        int totalHeight = curY;
        background.setHeight(totalHeight);

        // --- Center all widgets vertically ---
        int offsetY = (mc.getWindow().getHeight() - totalHeight) / 2;
        for (Widget widget : widgets) widget.moveY(offsetY);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        for (Widget w : widgets) {
            w.render(context);
        }
    }
    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        this.applyBlur(context);
        this.renderDarkening(context);
    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        double mx = mc.mouse.getX(), my = mc.mouse.getY();
        for (Widget widget : widgets) widget.mouseClicked(mx, my, button);
        return false;
    }
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) mc.setScreen(GuiScreen.INSTANCE);
        return false;
    }
    @Override
    public boolean shouldPause() {
        return false;
    }
}