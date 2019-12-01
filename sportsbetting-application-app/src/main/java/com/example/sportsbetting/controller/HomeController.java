package com.example.sportsbetting.controller;

import com.example.sportsbetting.repository.PlayerRepository;
import com.example.sportsbetting.service.SportsBettingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String welcome(ModelMap model){
        model.addAttribute("message", "Welcome to Home Page!");

        return "welcome";
    }
}
