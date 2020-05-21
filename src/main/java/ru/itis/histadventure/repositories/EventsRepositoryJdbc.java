package ru.itis.histadventure.repositories;

import org.springframework.data.repository.query.Param;
import ru.itis.histadventure.models.Event;

import java.util.Optional;

public interface EventsRepositoryJdbc extends CrudRepository<Event, Long>{
    Optional<Event> findOneByName(String name);
}
