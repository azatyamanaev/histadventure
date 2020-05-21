package ru.itis.histadventure.repositories;

import ru.itis.histadventure.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByLogin(String login);
    void deleteOneByLogin(String login);
}
