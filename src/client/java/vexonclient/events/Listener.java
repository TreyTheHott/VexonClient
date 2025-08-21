package vexonclient.events;

import vexonclient.VexonClient;

import java.lang.reflect.Method;

/**
 * Used by the EventBus to invoke annotated methods
 * on registered listener objects via reflection.
 */
public class Listener {
    private final Object owner;
    private final Method method;

    public Listener(Object owner, Method method) {
        this.owner = owner;
        this.method = method;
    }

    public void invoke(Event event) {
        try {
            this.method.invoke(event);
        } catch (Exception e) {
            VexonClient.LOGGER.error("[Listener] {}", e.getMessage());
        }
    }
}