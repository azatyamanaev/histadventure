package ru.itis.histadventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.histadventure.dto.UserDto;
import ru.itis.histadventure.models.Role;
import ru.itis.histadventure.models.User;
import ru.itis.histadventure.services.AuthService;
import ru.itis.histadventure.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthService authService;

    @GetMapping("/users")
    public String getUsersPage(Model model, HttpServletRequest request) {
        Cookie[] ck = request.getCookies();
        if (authService.hasRole(ck, Role.ADMIN)) {
            List<UserDto> users = usersService.getAllUsers();
            model.addAttribute("users", users);
            return "users";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserProfile(@RequestParam("user_login") String userLogin, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] ck = request.getCookies();
        if (authService.hasRole(ck, Role.ADMIN)) {
            modelAndView.setViewName("other_profile");
            User user = usersService.findUserByLogin(userLogin);
            modelAndView.addObject("user", user);
        } else {
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

}
