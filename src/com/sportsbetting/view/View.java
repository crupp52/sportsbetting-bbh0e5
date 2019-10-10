package com.sportsbetting.view;

import com.sportsbetting.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class View {
    static Random rnd = new Random();

    public Player readPlayer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Player player = new Player();
        System.out.println("What is your name?");
        player.setName(reader.readLine());
        System.out.println("How much money do you have (more than 0)?");
        player.setBalance(new BigDecimal(reader.readLine()));
        System.out.println("What is your currency? (HUF, EUR or USD)");
        switch (reader.readLine()) {
            case "HUF":
                player.setCurrency(Currency.HUF);
                break;
            case "EUR":
                player.setCurrency(Currency.EUR);
                break;
            default:
                player.setCurrency(Currency.USD);
                break;
        }

        return player;
    }

    public void printWelcomeMessage(Player player) {
        System.out.println("Welcome " + player.getName());
    }

    public void printBalance(Player player) {
        System.out.println("Your balance is " + player.getBalance() + " " + player.getCurrency().toString());
    }

    public void printOutcomeOdds(List<SportEvent> sportEvents) {
        for (SportEvent sportEvent : sportEvents) {
            System.out.println(sportEvent.toString());
        }
    }

    public OutcomeOdd selectOutcomeOdd(List<OutcomeOdd> outcomeOdds) {
        return outcomeOdds.get(rnd.nextInt(outcomeOdds.size()));
    }

    public BigDecimal readWagerAmount(Wager wager) {
        return wager.getAmount();
    }

    public void printWagerSaved(Wager wager) {
        System.out.println("Wager '" + wager.toString() + "' of " + wager.getOutcomeOdd().getOutcome().getBet().getEvent().getTitle() + " [odd: " + wager.getOutcomeOdd().getValue() + ", amount: " + wager.getAmount() + "] saved!");
    }

    public void printNotEnoughBalance(Player player) {
        System.out.println("You don't have enough money, your balance is " + player.getBalance() + " " + player.getCurrency().toString() + ".");
    }

    public void printResult(Player player, List<Wager> wagers) {

    }
}
