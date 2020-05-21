package ru.itis.histadventure.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.histadventure.models.FileInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class FilesRepositoryJpaImpl implements FilesRepository {

    //language=SQL
    private final String SQL_SELECT_ALL = "select * from files";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from files where id = ?";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(FileInfo model) {
        entityManager.persist(model);
    }

    @Override
    public void update(FileInfo model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter(1, id);
    }

    @Override
    public Optional<FileInfo> find(Long id) {
        return Optional.ofNullable(entityManager.find(FileInfo.class, id));
    }

    @Override
    public List<FileInfo> findAll() {
        return entityManager.createQuery(SQL_SELECT_ALL, FileInfo.class).getResultList();
    }
}
