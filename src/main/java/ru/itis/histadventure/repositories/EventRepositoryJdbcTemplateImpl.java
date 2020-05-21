package ru.itis.histadventure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.histadventure.models.Event;
import ru.itis.histadventure.models.User;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class EventRepositoryJdbcTemplateImpl implements EventsRepositoryJdbc {

    //language=SQL
    private final String SQL_INSERT_EVENT = "insert into events";
    //language=SQL
    private final String SQL_UPDATE_EVENT = "update events \n" +
            "set capacity = ?, description = ?, name = ?, host = ?, \n" +
            "place = ?, time_end = ?, time_start = ?, count_like = ? \n" +
            "where id = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from events";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "select * from events where id = ?";
    //language=SQL
    private final String SQL_SELECT_BY_NAME = "select * from events where name = ?";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from events where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Event> eventRowMapper = (row, rowNumber) ->
            Event.builder()
                    .id(row.getLong("id"))
                    .active(row.getBoolean("active"))
                    .capacity(row.getInt("capacity"))
                    .countLike(row.getInt("count_like"))
                    .description(row.getString("description"))
                    .host(row.getString("host"))
                    .name(row.getString("name"))
                    .place(row.getString("place"))
                    .timeStart(row.getString("time_start"))
                    .timeEnd(row.getString("time_end"))
                    .build();


    public void save(Event model) {

    }


    public void update(Event model) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_UPDATE_EVENT);
            statement.setInt(1, model.getCapacity());
            statement.setString(2, model.getDescription());
            statement.setString(3, model.getName());
            statement.setString(4, model.getHost());
            statement.setString(5, model.getPlace());
            statement.setString(6, model.getTimeEnd());
            statement.setString(7, model.getTimeStart());
            statement.setInt(8, model.getCountLike());
            statement.setLong(9, model.getId());
            return statement;
        });
    }


    public void delete(Long aLong) {

    }


    public Optional<Event> find(Long id) {
        try {
            Event event = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, eventRowMapper);
            return Optional.ofNullable(event);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    public List<Event> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, eventRowMapper);
    }


    public Optional<Event> findOneByName(String name) {
        try {
            Event event = jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, new Object[]{name}, eventRowMapper);
            return Optional.ofNullable(event);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
