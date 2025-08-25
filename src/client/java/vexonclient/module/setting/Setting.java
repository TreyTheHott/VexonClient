package vexonclient.module.setting;

public abstract class Setting<T> {
    private final String name, description;
    private T value;

    public Setting(String name, String description, T value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}