package com.example.sportsbetting;

import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.service.SportsBettingService;
import com.example.sportsbetting.view.View;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class App {
    private SportsBettingService sportsBettingService;
    private View view;
    private Logger logger;

    public App(SportsBettingService sportsBettingService, View view) {
        this.sportsBettingService = sportsBettingService;
        this.view = view;
    }

    public void play() throws IOException {
        logger.info("Player Creation");
        createPlayer();
        logger.info("Do betting");
        doBetting();
        logger.info("Do Caltulate Result");
        calculateResult();

        logger.info("Do Print result");
        printResult(sportsBettingService.findPlayer(), sportsBettingService.getWagers());
    }

    private void createPlayer() throws IOException {
        Player p = view.readPlayer();
        sportsBettingService.SavePlayer(p);
        view.printWelcomeMessage(p);
        view.printBalance(p);
    }

    private void doBetting() throws IOException {
        OutcomeOdd outcomeOdd = view.selectOutcomeOdd(sportsBettingService.getSportEvents());
        while (outcomeOdd != null) {

            Wager wager = new Wager(view.readWagerAmount(), sportsBettingService.findPlayer(), outcomeOdd);
            if (sportsBettingService.saveWager(wager)) {
                view.printWagerSaved(wager);
            } else {
                view.printNotEnoughBalance(sportsBettingService.findPlayer());
            }
            outcomeOdd = view.selectOutcomeOdd(sportsBettingService.getSportEvents());

        }
    }

    private void calculateResult() {
        sportsBettingService.calculateResult();
    }

    private void printResult(Player player, List<Wager> wagers) {
        view.printResult(player, wagers);
    }

    public void setLocale(Locale locale) {
        view.setLocale(locale);
    }

    public void setMessageSource(MessageSource messageSource) {
        view.setMessageSource(messageSource);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
