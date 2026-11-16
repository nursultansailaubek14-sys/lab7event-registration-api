package kz.iitu.registration.service;

import kz.iitu.registration.model.EventInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Business logic layer. Spring creates one instance of this class (a bean)
 * and injects it wherever it is requested in a constructor.
 */
@Service
public class EventService {

    private final List<EventInfo> events = List.of(
            new EventInfo(1, "Web Design Workshop", "Room 101"),
            new EventInfo(2, "JavaScript Quiz", "Room 204"),
            new EventInfo(3, "IT Career Talk", "Main Hall")
    );

    public String getWelcomeMessage() {
        return "Welcome to the Event Registration API";
    }

    public List<EventInfo> getAllEvents() {
        return events;
    }

    // Bonus: find one event by id
    public Optional<EventInfo> getEventById(int id) {
        return events.stream()
                .filter(event -> event.id() == id)
                .findFirst();
    }
}
