package com.example.sportsbetting.controller;

import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.service.SportsBettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
            model.addAttribute("wagers", service.getWagerInfos());
            return "home";
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RedirectView add(Player p) {
        service.savePlayer(p);
        return new RedirectView("redirect:/home");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView add(@RequestParam String id) {
        service.deleteWager(id);
        return new ModelAndView("redirect:/home");
    }
}
