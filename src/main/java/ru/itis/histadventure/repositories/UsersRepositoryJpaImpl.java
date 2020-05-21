package ru.itis.histadventure.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.histadventure.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryJpaImpl implements UsersRepository {

    //language=SQL
    private final String SQL_SELECT_ALL = "select * from users";
    //language=SQL
    private final String SQL_SELECT_BY_LOGIN = "select * from users where login = ?";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from users where id = ?";
    //language=SQL
    private final String SQL_DELETE_BY_LOGIN = "delete from users where login = ?";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findOneByLogin(String login) {
        return Optional.ofNullable(entityManager.createQuery(SQL_SELECT_BY_LOGIN, User.class).setParameter(1, login).getSingleResult());
    }

    @Override
    public void deleteOneByLogin(String login) {
        entityManager.createQuery(SQL_DELETE_BY_LOGIN).setParameter(1, login);
    }

    @Override
    @Transactional
    public void save(User model) {
        entityManager.persist(model);
    }

    @Override
    public void update(User model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery(SQL_DELETE_BY_ID).setParameter(1, id);
    }

    @Override
    public Optional<User> find(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from users", User.class).getResultList();
    }
}
