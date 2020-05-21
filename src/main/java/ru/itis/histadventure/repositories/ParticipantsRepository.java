package ru.itis.histadventure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.histadventure.dto.UserEventsDto;

import java.util.List;

import java.sql.PreparedStatement;

public class ParticipantsRepository {
    //language=SQL
    private final String PARTICIPATE = "insert into participants " +
            "(event_id, user_id) values (?, ?)";
    //language=SQL
    private final String SELECT_ALL = "select * from participants";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<UserEventsDto> userEventsDtoRowMapper = (row, rowNumber) ->
            UserEventsDto.builder()
                    .userId(row.getLong("user_id"))
                    .eventId(row.getLong("event_id"))
                    .build();

    public void participate(Long eventId, Long userId) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(PARTICIPATE);
            statement.setLong(1, eventId);
            statement.setLong(2, userId);
            return statement;
        });
    }

    public List<UserEventsDto> findAllParticipants() {
        return jdbcTemplate.query(SELECT_ALL, userEventsDtoRowMapper);
    }
}
