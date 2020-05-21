package ru.itis.histadventure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.histadventure.dto.UserEventsDto;

import java.sql.PreparedStatement;
import java.util.List;

public class UserEventsRepository {
    //language=SQL
    private final String SUBSCRIBE = "insert into subscribed_events " +
            "(user_id, event_id) values (?, ?)";
    //language=SQL
    private final String CREATE_EVENT = "insert into created_events " +
            "(user_id, event_id) values (?, ?)";
    //language=SQL
    private final String SELECT_ALL_SUBSCRIBED_EVENTS = "select * from subscribed_events";
    //language=SQL
    private final String SELECT_ALL_CREATED_EVENTS = "select * from created_events";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<UserEventsDto> userEventsDtoRowMapper = (row, rowNumber) ->
            UserEventsDto.builder()
                    .userId(row.getLong("user_id"))
                    .eventId(row.getLong("event_id"))
                    .build();


    public void subscribe(Long userId, Long eventId) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SUBSCRIBE);
            statement.setLong(1, userId);
            statement.setLong(2, eventId);
            return statement;
        });
    }

    public void createEvent(Long userId, Long eventId) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(CREATE_EVENT);
            statement.setLong(1, userId);
            statement.setLong(2, eventId);
            return statement;
        });
    }

    public List<UserEventsDto> findAllCreatedEvents() {
        return jdbcTemplate.query(SELECT_ALL_CREATED_EVENTS, userEventsDtoRowMapper);
    }
    public List<UserEventsDto> findAlLSubscribedEvents() {
        return jdbcTemplate.query(SELECT_ALL_SUBSCRIBED_EVENTS, userEventsDtoRowMapper);
    }

}
