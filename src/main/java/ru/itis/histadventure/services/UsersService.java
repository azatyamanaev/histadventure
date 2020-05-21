package ru.itis.histadventure.services;

import ru.itis.histadventure.dto.UserDto;
import ru.itis.histadventure.models.User;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
    User findUserByLogin(String login);
    void updateUser(String login, String email, String prLogin);
    void update(User user);
}
