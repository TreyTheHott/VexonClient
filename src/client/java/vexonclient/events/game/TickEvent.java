package vexonclient.events.game;

import vexonclient.events.Event;

public class TickEvent extends Event {
    public static class Pre extends TickEvent { }
    public static class Post extends TickEvent { }
}