package ru.itis.histadventure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.histadventure.models.FileInfo;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class FilesRepositoryJdbcTemplateImpl implements FilesRepository {

    //language=SQL
    private final String SQL_INSERT_FILE = "insert into files" +
            "(storage_file_name, original_file_name, size, type, url) values (?, ?, ?, ?, ?)";
    //language=SQL
    private final String SQL_UPDATE_FILE = "update files \n" +
            "set storage_file_name = ?, original_file_name = ?, size = ?, type = ?, url = ? \n" +
            "where id = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from files";
    //language=SQL
    private final String SQL_SELECT_FILE_BY_ID = "select * from files where id = ?";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from files where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<FileInfo> fileInfoRowMapper = (row, rowNumber) ->
            FileInfo.builder()
                    .id(row.getLong("id"))
                    .storageFileName(row.getString("storage_file_name"))
                    .originalFileName(row.getString("original_file_name"))
                    .size(row.getLong("size"))
                    .type(row.getString("type"))
                    .url(row.getString("url"))
                    .build();

    @Override
    public void save(FileInfo model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_INSERT_FILE);
            statement.setString(1, model.getStorageFileName());
            statement.setString(2, model.getOriginalFileName());
            statement.setLong(3, model.getSize());
            statement.setString(4, model.getType());
            statement.setString(5, model.getUrl());
            return statement;
        }, keyHolder);
        model.setId((Long) keyHolder.getKey());
    }

    @Override
    public void update(FileInfo model) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_UPDATE_FILE);
            statement.setString(1, model.getStorageFileName());
            statement.setString(2, model.getOriginalFileName());
            statement.setLong(3, model.getSize());
            statement.setString(4, model.getType());
            statement.setString(5, model.getUrl());
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
    public Optional<FileInfo> find(Long id) {
        try {
            FileInfo fileInfo = jdbcTemplate.queryForObject(SQL_SELECT_FILE_BY_ID, new Object[]{id}, fileInfoRowMapper);
            return Optional.ofNullable(fileInfo);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<FileInfo> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, fileInfoRowMapper);
    }
}
