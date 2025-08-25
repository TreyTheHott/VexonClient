package vexonclient.module;

import net.minecraft.client.option.KeyBinding;
import vexonclient.module.setting.SettingBoolean;
import vexonclient.utils.Category;
import vexonclient.utils.input.Keybinds;

import java.util.ArrayList;
import java.util.List;

public class Module {
    private final String name, description;
    private final Category category;
    private final List<ModuleCategory> categories = new ArrayList<>();
    private boolean active = false;

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Category getCategory() {
        return category;
    }
    public List<ModuleCategory> getCategories() {
        return categories;
    }
    public ModuleCategory addCategory(String name) {
        ModuleCategory temp = new ModuleCategory(name);
        categories.add(temp);
        return temp;
    }
    public KeyBinding getKeybind() {
        return Keybinds.binds.get(this);
    }
    public void setKeybind(KeyBinding keyBinding) {
        Keybinds.binds.put(this, keyBinding);
    }
    public boolean isActive() {
        return active;
    }
    public void toggleActive() {
        setActive(!active);
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void finalizeCategories() {
        addCategory("Bind")
                .addSetting(new SettingBoolean("Toggle on bind release", "", false))
                .addSetting(new SettingBoolean("Chat Feedback", "", true));
        addCategory("")
                .addSetting(new SettingBoolean("Active", "", false));
    }
}