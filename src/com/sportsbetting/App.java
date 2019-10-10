package com.sportsbetting;

import com.sportsbetting.model.Player;
import com.sportsbetting.model.SportEvent;
import com.sportsbetting.model.Wager;
import com.sportsbetting.service.SportsBettingService;
import com.sportsbetting.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        App app = new App(new SportsBettingService(), new View());
        app.play();
    }

    private SportsBettingService sportsBettingService;
    private View view;

    public App(SportsBettingService sportsBettingService, View view) {
        this.sportsBettingService = sportsBettingService;
        this.view = view;
    }

    public void play() throws IOException {
        this.createPlayer();

        this.doBetting();
        this.calculateResult();
        this.printResult();
    }

    private void createPlayer() throws IOException {
        Player p = this.view.readPlayer();
        this.sportsBettingService.SavePlayer(p);
        this.view.printWelcomeMessage(p);
        this.view.printBalance(p);
    }

    private void doBetting() {
        this.view.printOutcomeOdds(this.sportsBettingService.getSportEvents());
    }

    private void calculateResult() {

    }

    private void printResult() {

    }
}
