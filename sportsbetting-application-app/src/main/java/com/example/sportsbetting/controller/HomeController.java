package com.example.sportsbetting.controller;

import com.example.sportsbetting.service.SportsBettingService;
import com.example.sportsbetting.service.SportsBettingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private SportsBettingService service;

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        if (service.getLoggedInUser() == null) {
            return "redirect:login";
        } else {
            model.addAttribute("user", service.getLoggedInUser());
            model.addAttribute("wagers", service.getLoggedInUserWagers());
            return "home";
        }
    }
}
