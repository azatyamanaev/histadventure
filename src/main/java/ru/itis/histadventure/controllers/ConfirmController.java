package ru.itis.histadventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.histadventure.services.ConfirmUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ConfirmController {

    @Autowired
    private ConfirmUser confirmUser;

    @Value("${secret.key}")
    private String secretKey;

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public ModelAndView getConfirmPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    @RequestMapping(value = "/confirming", method = RequestMethod.GET)
    public ModelAndView confirmUser(String key, String login, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        if (key.equals(secretKey)) {
            Cookie cookie = new Cookie("login", login);
            Cookie authCookie = new Cookie("auth", "true");
            response.addCookie(authCookie);
            response.addCookie(cookie);
            confirmUser.confirm(login);
            modelAndView.setViewName("redirect:/profile");
        } else {
            modelAndView.setViewName("redirect:/confirm_error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/confirm_error", method = RequestMethod.GET)
    public ModelAndView getConfirmErrorPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm_error");
        return modelAndView;
    }
}
