package ru.itis.histadventure.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.histadventure.models.Role;
import ru.itis.histadventure.models.User;

import javax.servlet.http.Cookie;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UsersService usersService;

    @Override
    public boolean isAuth(Cookie[] ck) {
        if (ck != null) {
            String auth = ck[2].getValue();
            return auth.equals("true");
        }
        return false;
    }

    @Override
    public boolean hasRole(Cookie[] ck, Role role) {
        if (ck != null) {
            String auth = ck[2].getValue();
            String login = ck[3].getValue();
            User user = usersService.findUserByLogin(login);
            return auth.equals("true") && user.getRole().equals(role);
        }
        return false;
    }
}
