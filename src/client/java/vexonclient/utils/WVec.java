package vexonclient.utils;

public class WVec {
    public int x, y, width, height, color;
    public String text;

    public WVec() {}
    public WVec(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public WVec(int x, int y, int width, int height, int color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public WVec(int x, int y, int width, int height, int color, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.text = text;
    }
    public WVec(int x, int y, int color, String text) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.text = text;
    }
}