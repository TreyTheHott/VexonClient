package vexonclient.events.game;

import vexonclient.events.Event;

/**
 * Fired each Minecraft tick (Pre-tick and Post-tick)
 */
public class TickEvent extends Event {
    public static class Pre extends TickEvent { }
    public static class Post extends TickEvent { }
}