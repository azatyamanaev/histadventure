package ru.itis.histadventure.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.histadventure.models.Event;
import ru.itis.histadventure.models.User;
import ru.itis.histadventure.services.EventsService;
import ru.itis.histadventure.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class EventsController {

    @Autowired
    private EventsService eventsService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/events")
    public String getEventsPage(Model model) {
        List<Event> eventList = eventsService.getAllEvents();
        model.addAttribute("events", eventList);
        return "events";
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public ModelAndView getEventPage(@RequestParam("event_name") String eventName, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Event event = eventsService.findEventByName(eventName);
        modelAndView.addObject("event", event);
        modelAndView.addObject("login", request.getCookies()[3].getValue());
        event.setParticipants(eventsService.getParticipantsForEvent(eventName));
        modelAndView.addObject("participants", event.getParticipants());
        modelAndView.setViewName("event");
        return modelAndView;
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String edit(@RequestParam("name") String name, @RequestParam("description") String description,
                                       @RequestParam("capacity") Integer capacity, @RequestParam("place") String place,
                                       @RequestParam("time_start") String timeStart, @RequestParam("time_end") String timeEnd,
                                       HttpServletRequest request, @RequestParam("pr_name") String prName) {
        Cookie[] ck = request.getCookies();
        String host = ck[3].getValue();
        Long eventId = eventsService.findEventByName(prName).getId();
        int countLike = eventsService.findEventByName(prName).getCountLike();
        eventsService.updateEvent(Event.builder()
                .id(eventId)
                .name(name)
                .countLike(countLike)
                .host(host)
                .description(description)
                .capacity(capacity)
                .place(place)
                .timeEnd(timeEnd)
                .timeStart(timeStart)
                .build());
        return "redirect:/event?event_name=" + name;
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)
    public String subscribe(@RequestParam("event_name") String name, HttpServletRequest request) {
        User user = usersService.findUserByLogin(request.getCookies()[3].getValue());
        Event event = eventsService.findEventByName(name);
        eventsService.subscribe(user.getId(), event.getId());
        event.setCountLike(event.getCountLike() + 1);
        eventsService.saveEvent(event);
        return "redirect:/event?event_name=" + name;
    }

    @RequestMapping(value = "/participate", method = RequestMethod.GET)
    public String participate(@RequestParam("event_name") String name, HttpServletRequest request) {
        User user = usersService.findUserByLogin(request.getCookies()[3].getValue());
        Event event = eventsService.findEventByName(name);
        eventsService.participate(event.getId(), user.getId());
        return "redirect:/event?event_name=" + name;
    }
}
