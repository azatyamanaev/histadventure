package ru.itis.histadventure.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.histadventure.models.User;
import ru.itis.histadventure.repositories.UserEventsRepository;
import ru.itis.histadventure.services.AuthService;
import ru.itis.histadventure.services.EventsService;
import ru.itis.histadventure.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@Slf4j
public class ProfileController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private EventsService eventsService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView getProfilePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] ck = request.getCookies();
        String login = ck[3].getValue();
        User user = usersService.findUserByLogin(login);
        user.setCreatedEvents(eventsService.getCreatedEventsForUser(user.getLogin()));
        user.setSubscribedEvents(eventsService.getSubscribedEventsForUser(user.getLogin()));
        if (authService.isAuth(ck)) {
            modelAndView.addObject("login", login);
            modelAndView.addObject("email", user.getEmail());
            modelAndView.addObject("created_events", user.getCreatedEvents());
            modelAndView.addObject("subscribed_events", user.getSubscribedEvents());
            modelAndView.addObject("likes", user.getSubscribedEvents().size());
            modelAndView.setViewName("profile");
        } else {
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> saveChanges(@RequestParam("login") String login, @RequestParam("email") String email, HttpServletResponse response, Model model, HttpServletRequest request) {
        String prLogin = request.getCookies()[3].getValue();
        usersService.updateUser(login, email, prLogin);
        Cookie cookie = new Cookie("login", login);
        response.addCookie(cookie);
        model.addAttribute("login", login);
        model.addAttribute("email", email);
        return ResponseEntity.ok("changes saved");
    }

    @RequestMapping(value = "/other_profile", method = RequestMethod.GET)
    public ModelAndView getOtherProfile(@RequestParam("login") String login, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        User user = usersService.findUserByLogin(login);
        if (user.getLogin().equals(request.getCookies()[3].getValue())) {
            modelAndView.setViewName("redirect:/profile");
            return modelAndView;
        }
        user.setCreatedEvents(eventsService.getCreatedEventsForUser(user.getLogin()));
        user.setSubscribedEvents(eventsService.getSubscribedEventsForUser(user.getLogin()));

        modelAndView.addObject("created_events", user.getCreatedEvents());
        modelAndView.addObject("subscribed_events", user.getSubscribedEvents());
        modelAndView.addObject("likes", 0);
        if (user.getSubscribedEvents() != null) {
            modelAndView.addObject("likes", user.getSubscribedEvents().size());
        }
        modelAndView.addObject("user", user);
        modelAndView.setViewName("other_profile");
        return modelAndView;
    }

    @RequestMapping(value = "/profile_image", method = RequestMethod.POST)
    public String chooseImage(MultipartFile multipartFile, HttpServletRequest request) {
        log.info("yes");
        User user = usersService.findUserByLogin(request.getCookies()[3].getValue());
        user.setImage((File) multipartFile);
        usersService.update(user);
        return "/profile";
    }
}
