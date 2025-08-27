package vexonclient.module.modules.render;

import vexonclient.module.Module;
import vexonclient.module.setting.SettingSelection;
import vexonclient.utils.Category;

import java.util.List;

public class Fullbright extends Module {
    public Fullbright() {
        super("Fullbright", "Lights up your world!", Category.Render);
        addCategory("General")
                .addSetting(new SettingSelection("Mode", "The mode to use for Fullbright", "Gamma", List.of("Gamma", "Potion")));
        finalizeCategories();
    }
}