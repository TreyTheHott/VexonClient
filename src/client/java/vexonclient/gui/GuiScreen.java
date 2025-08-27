package vexonclient.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import vexonclient.VexonClient;
import vexonclient.utils.Category;

import java.util.ArrayList;
import java.util.List;

public class GuiScreen extends Screen {
    public static final GuiScreen INSTANCE = new GuiScreen();
    private final List<GuiTab> tabs = new ArrayList<>();
    private boolean open = false;

    public GuiScreen() {
        super(Text.literal(""));

        int x = 5;
        for (Category category : Category.values()) {
            tabs.add(new GuiTab(category, x, 5));
            x += 155;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        for (GuiTab tab : tabs) tab.render(context);
    }
    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        this.applyBlur(context);
        this.renderDarkening(context);
    }
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (GuiTab tab : tabs) tab.mouseClicked(VexonClient.mc.mouse.getX(), VexonClient.mc.mouse.getY(), button);
        return super.mouseClicked(mouseX, mouseY, button);
    }
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) setOpen(false);
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
    @Override
    public boolean shouldPause() {
        return false;
    }
    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
        VexonClient.mc.setScreen(open ? INSTANCE : null);
    }
}