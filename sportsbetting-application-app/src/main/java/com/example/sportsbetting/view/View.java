package com.example.sportsbetting.view;

import com.example.sportsbetting.domain.*;
import org.springframework.context.MessageSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    Locale locale;
    MessageSource messageSource;

    public View() {
        this.locale = Locale.ENGLISH;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private String getLocaleString(String string) {
        //return ResourceBundle.getBundle("resources/strings", locale).getString(string);
        return messageSource.getMessage(string, null, locale);
    }

    public Player readPlayer() throws IOException {
        Player player = new Player();
        System.out.println(getLocaleString("what_is_your_name"));
        player.setName(reader.readLine());
        //System.out.println("How much money do you have (more than 0)?");
        System.out.println(getLocaleString("how_much_money_do_you_have"));
        player.setBalance(new BigDecimal(reader.readLine()));
        System.out.println(getLocaleString("what_is_your_currency"));
        //System.out.println("What is your currency? (HUF, EUR or USD)");
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
        System.out.println(getLocaleString("welcome") + " " + player.getName());
    }

    public void printBalance(Player player) {
        System.out.println(getLocaleString("your_balance_is") + " " + player.getBalance() + " " + player.getCurrency().toString());
        //.out.println("Your balance is " + player.getBalance() + " " + player.getCurrency().toString());
    }

    public void printOutcomeOdds(List<SportEvent> sportEvents) {
        StringBuilder output = new StringBuilder();
        output.append(getLocaleString("what_are_you_want_to_bet_on")).append("\n");
        //output.append("What are you want to bet on? (choose a number or press q for quit)\n");
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
                        output.append("> ").append(i++).append(": ").append(sportEvent.toString()).append(", ").append(bet.toString()).append(", ").append(outcome.toString()).append(", ").append(outcomeOdd.getDatas()).append("\n");
                    }
                }
            }
        }
        System.out.println(output.toString());
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents) throws IOException {
        printOutcomeOdds(sportEvents);
        String input = reader.readLine();
        if (!input.equals("q")) {
            return getOutcomeOdd(sportEvents, Integer.parseInt(input));
        } else {
            return null;
        }
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
        System.out.println(getLocaleString("what_amount_dou_you_wish_to_bet_on_it"));
        //System.out.println("What amount do you wish to bet on it?");
        return BigDecimal.valueOf(Long.parseLong(reader.readLine()));
    }

    public void printWagerSaved(Wager wager) {
        System.out.println("Wager '" + wager.toString() + "' of " + wager.getOutcomeOdd().getOutcome().getBet().getEvent().getTitle() + " [odd: " + wager.getOutcomeOdd().getValue() + ", amount: " + wager.getAmount() + "] saved!");
    }

    public void printNotEnoughBalance(Player player) {
        System.out.println(getLocaleString("dont_have_enough_money") + " " + player.getBalance() + " " + player.getCurrency().toString() + ".");
        //System.out.println("You don't have enough money, your balance is " + player.getBalance() + " " + player.getCurrency().toString() + ".");
    }

    public void printResult(Player player, List<Wager> wagers) {
        for (Wager wager : wagers) {
            System.out.println(wager.getResultString());
        }
        System.out.println(getLocaleString("your_balance_is") + " " + player.getBalance() + " " + player.getCurrency());
        //System.out.println("Your new balance is " + player.getBalance() + " " + player.getCurrency());
    }
}
