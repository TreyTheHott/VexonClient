package vexonclient.module;

import vexonclient.module.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class ModuleCategory {
    private final String name;
    private final List<Setting<?>> settings = new ArrayList<>();

    public ModuleCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public List<Setting<?>> getSettings() {
        return settings;
    }
    public <T extends Setting<?>> ModuleCategory addSetting(T setting) {
        settings.add(setting);
        return this;
    }
}