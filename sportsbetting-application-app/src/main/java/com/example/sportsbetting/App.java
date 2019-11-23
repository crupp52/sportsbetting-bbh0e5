package com.example.sportsbetting;

import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.service.SportsBettingService;
import com.example.sportsbetting.view.View;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        App app = new App(new SportsBettingService(), new View());
        app.play();
    }

    private SportsBettingService sportsBettingService;
    private View view;

    private App(SportsBettingService sportsBettingService, View view) {
        this.sportsBettingService = sportsBettingService;
        this.view = view;
    }

    private void play() throws IOException {
        createPlayer();

        doBetting();
        calculateResult();

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
}
