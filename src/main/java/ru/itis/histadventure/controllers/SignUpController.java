package ru.itis.histadventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.histadventure.dto.SignUpDto;
import ru.itis.histadventure.services.SignUpService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ModelAndView signUp(SignUpDto form, HttpServletResponse response) {
        Boolean auth = signUpService.signUp(form);
        ModelAndView modelAndView = new ModelAndView();
        if (auth) {
            modelAndView.setViewName("redirect:/confirm");
        } else {
            modelAndView.setViewName("redirect:/signUp?error");
        }
        return modelAndView;
    }

}
