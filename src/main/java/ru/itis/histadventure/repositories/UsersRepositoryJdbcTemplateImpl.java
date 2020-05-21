package ru.itis.histadventure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.histadventure.models.Role;
import ru.itis.histadventure.models.State;
import ru.itis.histadventure.models.User;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private final String SQL_INSERT_CLIENT = "insert into users" +
            "(login, email, password, state, role) values (?, ?, ?, ?, ?)";
    //language=SQL
    private final String SQL_UPDATE_CLIENT = "update users \n" +
            "set login = ?, email = ?, password = ?, state = ?, role = ? \n" +
            "where id = ?;";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from users";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "select * from users where id = ?";
    //language=SQL
    private final String SQL_SELECT_BY_LOGIN = "select * from users where login = ?";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from users where id = ?";
    //language=SQL
    private final String SQL_DELETE_BY_LOGIN = "delete from users where login = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> clientRowMapper = (row, rowNumber) ->
            User.builder()
                    .id(row.getLong("id"))
                    .login(row.getString("login"))
                    .email(row.getString("email"))
                    .password(row.getString("password"))
                    .state(State.valueOf(row.getString("state")))
                    .role(Role.valueOf(row.getString("role")))
                    .build();

    @Override
    public Optional<User> findOneByLogin(String login) {
        try {
            User user = jdbcTemplate.queryForObject(SQL_SELECT_BY_LOGIN, new Object[]{login}, clientRowMapper);
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteOneByLogin(String login) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_DELETE_BY_LOGIN);
            statement.setString(1, login);
            return statement;
        });
    }

    @Override
    public void save(User model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_INSERT_CLIENT);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getEmail());
            statement.setString(3, model.getPassword());
            statement.setString(4, String.valueOf(model.getState()));
            statement.setString(5, String.valueOf(model.getRole()));
            return statement;
        }, keyHolder);
        model.setId((Long) keyHolder.getKey());
    }

    @Override
    public void update(User model) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_UPDATE_CLIENT);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getEmail());
            statement.setString(3, model.getPassword());
            statement.setString(4, model.getState().toString());
            statement.setString(5, model.getRole().toString());
            statement.setLong(6, model.getId());
            return statement;
        });

    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_DELETE_BY_ID);
            statement.setLong(1, id);
            return statement;
        });
    }

    @Override
    public Optional<User> find(Long id) {
        try {
            User user = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, clientRowMapper);
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, clientRowMapper);
    }
}
