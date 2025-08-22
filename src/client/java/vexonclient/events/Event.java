package vexonclient.events;

/**
 * Simple base class for events that can be cancelled.
 * <p>Event handlers may call {@link #setCancelled(boolean)} to stop
 * further processing if the event supports cancellation.
 */
public abstract class Event {
    private boolean cancelled = false;

    public boolean isCancelled() {
        return cancelled;
    }
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}