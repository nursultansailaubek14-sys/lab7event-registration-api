package kz.iitu.registration.controller;

import kz.iitu.registration.model.EventInfo;
import kz.iitu.registration.service.EventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final EventService eventService;

    // Settings from application.properties
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${app.course}")
    private String course;

    @Value("${app.semester}")
    private String semester;

    // Constructor-based dependency injection: Spring passes EventService here.
    public RegistrationController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", eventService.getWelcomeMessage());
    }

    @GetMapping("/events")
    public List<EventInfo> getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("applicationName", applicationName);
        result.put("course", course);
        result.put("semester", semester);
        return result;
    }

    // Bonus: GET /api/events/{id}
    @GetMapping("/events/{id}")
    public ResponseEntity<?> getEventById(@PathVariable int id) {
        Optional<EventInfo> event = eventService.getEventById(id);
        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Event with id " + id + " not found"));
    }
}
