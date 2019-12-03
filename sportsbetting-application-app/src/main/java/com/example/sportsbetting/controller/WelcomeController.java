package com.example.sportsbetting.controller;

import com.example.sportsbetting.service.SportsBettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    private SportsBettingService service;

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        return "welcome";
    }

}
