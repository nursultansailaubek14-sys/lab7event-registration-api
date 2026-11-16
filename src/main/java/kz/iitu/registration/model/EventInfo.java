package kz.iitu.registration.model;

/**
 * Simple data model for one event.
 * A record automatically gives us a constructor, getters (id(), title(), location())
 * and JSON serialization works with it out of the box.
 */
public record EventInfo(int id, String title, String location) {
}
