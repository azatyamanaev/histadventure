package ru.itis.histadventure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.histadventure.dto.UserDto;
import ru.itis.histadventure.models.User;
import ru.itis.histadventure.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    @Qualifier(value = "usersRepositoryJdbcTemplateImpl")
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public User findUserByLogin(String login) {
        Optional<User> userOptional = usersRepository.findOneByLogin(login);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user;
        }
        throw new UsernameNotFoundException("User not found");
    }

    @Override
    public void updateUser(String login, String email, String prLogin) {
        User user = findUserByLogin(prLogin);
        user.setLogin(login);
        user.setEmail(email);
        usersRepository.update(user);
    }

    @Override
    public void update(User user) {
        usersRepository.update(user);
    }

}
