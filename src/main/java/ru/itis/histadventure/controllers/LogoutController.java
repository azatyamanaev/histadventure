package ru.itis.histadventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.histadventure.dto.LogInDto;
import ru.itis.histadventure.services.LogInService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        Cookie ck = new Cookie("auth","");
        Cookie l = new Cookie("login", "");
        response.addCookie(ck);
        response.addCookie(l);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
