package ru.itis.histadventure.services;

import ru.itis.histadventure.models.Role;

import javax.servlet.http.Cookie;

public interface AuthService {
    boolean isAuth(Cookie[] ck);
    boolean hasRole(Cookie[] ck, Role role);
}
