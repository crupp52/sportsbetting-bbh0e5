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
        StringBuilder output = new StringBuilder();
        output.append("What are you want to bet on? (choose a number or press q for quit)\n");
        int i = 1;
        for (SportEvent sportEvent :
                sportEvents) {
            for (Bet bet :
                    sportEvent.getBets()
            ) {
                for (Outcome outcome :
                        bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd :
                            outcome.getOutcomeOdds()) {
                        output.append("> ").append(i++).append(": ").append(sportEvent.toString()).append(", ").append(bet.toString()).append(", ").append(outcome.toString()).append(", ").append(outcomeOdd.toString()).append("\n");
                    }
                }
            }
        }
        System.out.println(output.toString());
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) throws IOException {

        boolean end = false;

        while (!end) {
            printOutcomeOdds(sportEvents);
            String input = reader.readLine();
            if (input.equals("q")) {
                end = true;
            } else {
                OutcomeOdd outcomeOdd = getOutcomeOdd(sportEvents, Integer.parseInt(input));
                if (outcomeOdd != null) {
                    return outcomeOdd;
                }
            }
        }

        return null;
    }

    private OutcomeOdd getOutcomeOdd(List<SportEvent> sportEvents, int index) {
        int i = 1;
        for (SportEvent sportEvent :
                sportEvents) {
            for (Bet bet :
                    sportEvent.getBets()
            ) {
                for (Outcome outcome :
                        bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd :
                            outcome.getOutcomeOdds()) {
                        if (i == index) {
                            return outcomeOdd;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }

        return null;
    }

    public BigDecimal readWagerAmount() throws IOException {
        System.out.println("> What amount do you wish to bet on it?");
        return BigDecimal.valueOf(Long.parseLong(reader.readLine()));
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
