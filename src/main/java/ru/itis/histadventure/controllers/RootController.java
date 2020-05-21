package ru.itis.histadventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.histadventure.models.Role;
import ru.itis.histadventure.services.AuthService;
import ru.itis.histadventure.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getRootPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auth", false);
        modelAndView.addObject("role", "none");
        Cookie[] ck = request.getCookies();
        if (authService.isAuth(ck)) {
            String login = ck[3].getValue();
            Role role = usersService.findUserByLogin(login).getRole();
            modelAndView.addObject("role", role.toString());
            modelAndView.addObject("auth", true);
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
