package ru.itis.histadventure.services;

import ru.itis.histadventure.dto.UserEventsDto;
import ru.itis.histadventure.models.Event;
import ru.itis.histadventure.models.User;

import java.util.List;

public interface EventsService {
    List<Event> getAllEvents();
    Event findEventByName(String name);
    void saveEvent(Event event);
    void updateEvent(Event event);
    void subscribe(Long userId, Long eventId);
    void createEvent(Long userId, Long eventId);
    void participate(Long eventId, Long userId);
    List<Event> getSubscribedEventsForUser(String login);
    List<Event> getCreatedEventsForUser(String login);
    List<User> getParticipantsForEvent(String name);
}
