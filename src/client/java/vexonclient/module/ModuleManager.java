package vexonclient.module;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import vexonclient.VexonClient;
import vexonclient.utils.Category;

import java.util.*;
import java.util.stream.Collectors;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();
    private static final Map<String, Module> moduleByName = new HashMap<>();

    public static void init() {
        Reflections reflections = new Reflections("vexonclient.module.modules", Scanners.SubTypes);
        Set<Class<? extends Module>> moduleClasses = reflections.getSubTypesOf(Module.class);
        for (Class<? extends Module> moduleClass : moduleClasses) {
            try {
                Module module = moduleClass.getDeclaredConstructor().newInstance();
                register(module);
            } catch (Exception e) {
                VexonClient.LOGGER.info("[ModuleManager]::[init] {}", e.getMessage());
            }
        }
    }
    private static void register(Module module) {
        modules.add(module);
        moduleByName.put(module.getName(), module);
    }
    public static Module get(String name) {
        return moduleByName.get(name);
    }
    public static <T extends Module> T get(Class<T> clazz) {
        for (Module module : modules) if (clazz.isInstance(module)) return clazz.cast(module);
        return null;
    }
    public static List<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }
    public static List<Module> getModules(Category category) {
        return modules.stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
    }
    public static List<Module> getActiveModules() {
        return modules.stream().filter(Module::isActive).collect(Collectors.toList());
    }
}