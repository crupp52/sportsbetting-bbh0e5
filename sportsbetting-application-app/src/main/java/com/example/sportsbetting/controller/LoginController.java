package com.example.sportsbetting.controller;

import com.example.sportsbetting.service.SportsBettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SportsBettingService service;

    @RequestMapping(method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView login(String name, String password) {
        boolean result = service.Login(name, password);
        if (result) {
            return new RedirectView("/home");
        }

        return new RedirectView("/login");
    }
}
