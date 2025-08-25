package vexonclient.module.setting;

public class SettingNumber extends Setting<Double> {
    private final double min, max, increment;

    public SettingNumber(String name, String description, double value, double min, double max, double increment) {
        super(name, description, value);
        this.min = min;
        this.max = max;
        this.increment = increment;
    }

    public double getMin() {
        return min;
    }
    public double getMax() {
        return max;
    }
    public double getIncrement() {
        return increment;
    }
}