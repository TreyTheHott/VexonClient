package vexonclient.events;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * EventBus for registering listener objects and firing events.
 *
 * <p>Listeners are methods annoted with {@link EventListener} that take a single parameter
 * extending {@link Event}. Registering an object will automatically discover all such methods
 * and store them for fast event dispatch.
 */
public class EventBus {
    private final Map<Class<?>, List<Listener>> listeners = new HashMap<>();

    /**
     * Registers all listener methods of the given object.
     * Only methods annotated with {@link EventListener} that take a single Event subclass
     * parameter will be registered.
     * @param object the object containing listener methods
     */
    public void register(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventListener.class)
                    && method.getParameterCount() == 1
                    && Event.class.isAssignableFrom(method.getParameterTypes()[0])) {
                method.setAccessible(true);
                Class<?> eventType = method.getParameterTypes()[0];
                listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(new Listener(object, method));
            }
        }
    }

    /**
     * Fires an event to all registered listeners for its class.
     *
     * @param event the event instance to dispatch
     */
    public Event post(Event event) {
        List<Listener> eventListeners = listeners.getOrDefault(event.getClass(), Collections.emptyList());
        for (Listener listener : eventListeners) {
            listener.invoke(event);
        }
        return event;
    }
}