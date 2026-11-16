# Event Registration API (Laboratory Work 7)

First Spring Boot backend for the Event Registration scenario.
In-memory data only: no database, no frontend integration.

## Requirements
- JDK 17 or later
- Gradle (the Gradle wrapper `gradlew` / `gradlew.bat` is used)

## How to run
```bash
./gradlew bootRun        # Linux / macOS
gradlew.bat bootRun      # Windows
```
The server starts on http://localhost:8080.

## Endpoints
| Endpoint | Description |
| --- | --- |
| GET /api/hello | Welcome message from `EventService` |
| GET /api/events | Array with 3 events |
| GET /api/info | Application name, course, semester from `application.properties` |
| GET /api/events/{id} | Bonus: one event, or 404 with an error message |

## Structure
- **model/EventInfo**: record with `id`, `title`, `location`.
- **service/EventService**: `@Service` with the in-memory event list and welcome message.
- **controller/RegistrationController**: `@RestController` on `/api`. It receives `EventService`
  through its constructor (constructor-based dependency injection) and reads settings with `@Value`.
- **application.properties**: application name, course, semester.

## Dependency injection
The controller never calls `new EventService()`. Spring creates the `@Service` bean
and passes it to the controller constructor, so classes stay loosely coupled and easy to test.
