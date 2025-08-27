package vexonclient.module.setting;

import java.util.List;

public class SettingSelection extends Setting<String> {
    private final List<String> options;

    public SettingSelection(String name, String description, String value, List<String> options) {
        super(name, description, value);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }
}