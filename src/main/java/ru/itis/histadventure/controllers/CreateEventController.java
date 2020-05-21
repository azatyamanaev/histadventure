package ru.itis.histadventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.histadventure.models.Event;
import ru.itis.histadventure.services.EventsService;
import ru.itis.histadventure.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CreateEventController {

    @Autowired
    private EventsService eventsService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/createEvent", method = RequestMethod.POST)
    public String createEvent(@RequestParam("name") String name, @RequestParam("description") String description,
                                              @RequestParam("capacity") Integer capacity, @RequestParam("place") String place,
                                              @RequestParam("time_start") String timeStart, @RequestParam("time_end") String timeEnd,
                                              HttpServletRequest request) {
        Cookie[] ck = request.getCookies();
        String host = ck[3].getValue();
        eventsService.saveEvent(Event.builder()
                .name(name)
                .countLike(0)
                .host(host)
                .active(true)
                .description(description)
                .capacity(capacity)
                .place(place)
                .timeEnd(timeEnd)
                .timeStart(timeStart)
                .build());
        Long eventId = eventsService.findEventByName(name).getId();
        Long userId = usersService.findUserByLogin(host).getId();
        eventsService.createEvent(userId, eventId);

        return "redirect:/event?event_name=" + name;
    }

}
