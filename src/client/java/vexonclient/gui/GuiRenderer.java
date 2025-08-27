package vexonclient.gui;

import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;

import static vexonclient.VexonClient.mc;

public class GuiRenderer {
    public static void fill(DrawContext context, int x, int y, int w, int h, int c) {
        int guiScale = mc.getWindow().getScaleFactor();
        Matrix3x2fStack matrices = context.getMatrices();
        matrices.pushMatrix();
        matrices.scale(1f / guiScale, 1f / guiScale);

        context.fill(x, y, x + w, y + h, c);

        matrices.popMatrix();
    }

    public static void drawText(DrawContext context, String text, int x, int y, int color, boolean shadow) {
        int guiScale = mc.getWindow().getScaleFactor();
        float textScale = 1.85f;

        Matrix3x2fStack matrices = context.getMatrices();
        matrices.pushMatrix();
        matrices.scale(textScale / guiScale, textScale / guiScale);

        context.drawText(mc.textRenderer, text, (int)(x / textScale), (int)(y / textScale), color, shadow);

        matrices.popMatrix();
    }
    public static void drawTextCentered(DrawContext context, String text, int x, int y, int width, int height, int color, boolean shadow) {
        int guiScale = mc.getWindow().getScaleFactor();
        float textScale = 1.85f;

        Matrix3x2fStack matrices = context.getMatrices();
        matrices.pushMatrix();
        matrices.scale(textScale / guiScale, textScale / guiScale);

        float scaledX = x / textScale;
        float scaledY = y / textScale + (height / (2f * textScale)) - (mc.textRenderer.fontHeight / 2f);

        int textWidth = mc.textRenderer.getWidth(text);
        float textX = scaledX + (width / (2f * textScale)) - (textWidth / 2f);

        context.drawText(mc.textRenderer, text, (int)textX, (int)scaledY, color, shadow);

        matrices.popMatrix();
    }
    public static void drawTextHeader(DrawContext context, String text, int x, int y, int color, boolean shadow) {
        int guiScale = mc.getWindow().getScaleFactor();
        Matrix3x2fStack matrices = context.getMatrices();
        matrices.pushMatrix();
        matrices.scale(2f / guiScale, 2f / guiScale);

        context.drawText(mc.textRenderer, text, x, y, color, shadow);

        matrices.popMatrix();
    }
    public static void drawTextHeaderCentered(DrawContext context, String text, int x, int y, int width, int height, int color, boolean shadow) {
        int guiScale = mc.getWindow().getScaleFactor();
        float textScale = 2.5f;

        Matrix3x2fStack matrices = context.getMatrices();
        matrices.pushMatrix();
        matrices.scale(textScale / guiScale, textScale / guiScale);

        float scaledX = x / textScale;
        float scaledY = y / textScale + (height / (2f * textScale)) - (mc.textRenderer.fontHeight / 2f);

        int textWidth = mc.textRenderer.getWidth(text);
        float textX = scaledX + (width / (2f * textScale)) - (textWidth / 2f);

        context.drawText(mc.textRenderer, text, (int)textX, (int)scaledY, color, shadow);

        matrices.popMatrix();
    }
}