package ru.itis.histadventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.histadventure.services.AuthService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class ChatController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String getChatPage(HttpServletRequest request, Model model) {
        Cookie[] ck = request.getCookies();
        if (authService.isAuth(ck)) {
            model.addAttribute("pageId", UUID.randomUUID().toString());
            model.addAttribute("name", "Chat");
            model.addAttribute("login", ck[3].getValue());
            return "chat";
        } else {
            return "redirect:/logIn";
        }
    }
}
