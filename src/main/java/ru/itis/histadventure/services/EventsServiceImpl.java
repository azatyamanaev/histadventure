package ru.itis.histadventure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.itis.histadventure.dto.UserEventsDto;
import ru.itis.histadventure.models.Event;
import ru.itis.histadventure.models.User;
import ru.itis.histadventure.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private EventsRepositoryJdbc eventsRepositoryJdbc;
    @Autowired
    private UserEventsRepository userEventsRepository;
    @Autowired
    private ParticipantsRepository participantsRepository;
    @Autowired
    @Qualifier(value = "usersRepositoryJdbcTemplateImpl")
    private UsersRepository usersRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventsRepository.findAll();
    }

    @Override
    public Event findEventByName(String name) {
        Optional<Event> eventOptional = eventsRepositoryJdbc.findOneByName(name);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            return event;
        }
        throw new IllegalStateException("Event not found");
    }

    @Override
    public void saveEvent(Event event) {
        eventsRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventsRepositoryJdbc.update(event);
    }

    @Override
    public void subscribe(Long userId, Long eventId) {
        userEventsRepository.subscribe(userId, eventId);
    }

    @Override
    public void createEvent(Long userId, Long eventId) {
        userEventsRepository.createEvent(userId, eventId);
    }

    @Override
    public void participate(Long eventId, Long userId) {
        participantsRepository.participate(eventId, userId);
    }

    @Override
    public List<Event> getSubscribedEventsForUser(String login) {
        Long id = usersRepository.findOneByLogin(login).get().getId();
        List<UserEventsDto> userEventsDtos = userEventsRepository.findAlLSubscribedEvents();
        List<Event> events = new ArrayList<>();
        for (UserEventsDto userEventsDto : userEventsDtos) {
            if (userEventsDto.getUserId().equals(id)) {
                Optional<Event> event = eventsRepositoryJdbc.find(userEventsDto.getEventId());
                event.ifPresent(events::add);
            }
        }
        return events;
    }

    @Override
    public List<Event> getCreatedEventsForUser(String login) {
        Long id = usersRepository.findOneByLogin(login).get().getId();
        List<UserEventsDto> userEventsDtos = userEventsRepository.findAllCreatedEvents();
        List<Event> events = new ArrayList<>();
        for (UserEventsDto userEventsDto : userEventsDtos) {
            if (userEventsDto.getUserId().equals(id)) {
                Optional<Event> event = eventsRepositoryJdbc.find(userEventsDto.getEventId());
                event.ifPresent(events::add);
            }
        }
        return events;
    }

    @Override
    public List<User> getParticipantsForEvent(String name) {
        Long id = eventsRepositoryJdbc.findOneByName(name).get().getId();
        List<UserEventsDto> userEventsDtos = participantsRepository.findAllParticipants();
        List<User> users = new ArrayList<>();
        for (UserEventsDto userEventsDto : userEventsDtos) {
            if (userEventsDto.getEventId().equals(id)) {
                Optional<User> userOptional = usersRepository.find(userEventsDto.getUserId());
                userOptional.ifPresent(users::add);
            }
        }
        return users;
    }

}
