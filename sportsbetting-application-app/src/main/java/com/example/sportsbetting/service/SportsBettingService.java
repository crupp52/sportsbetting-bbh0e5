package com.example.sportsbetting.service;

import com.example.sportsbetting.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SportsBettingService {
    private List<Player> players;
    private List<SportEvent> sportEvents;
    private List<Wager> wagers;

    Random rnd = new Random();

    public SportsBettingService() {
        this.players = new ArrayList<>();
        this.sportEvents = new ArrayList<>();
        this.wagers = new ArrayList<>();

        Initialize();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<SportEvent> getSportEvents() {
        return this.sportEvents;
    }

    public List<Wager> getWagers() {
        return this.wagers;
    }

    public void Initialize() {
        SportEvent sportEvent = new FootballSportEvent("Football Match - EPIC", LocalDateTime.of(2019, 10, 10, 20, 0), LocalDateTime.of(2019, 10, 10, 22, 0));
        Bet bet = new Bet(BetType.NUMBER_OF_SETS);
        bet.setDescription("Bet01");
        Outcome outcome = new Outcome("Coutcome0");
        OutcomeOdd outcomeOdd = new OutcomeOdd();
        outcomeOdd.setValue(BigDecimal.valueOf(200));
        outcomeOdd.setValidFrom(LocalDateTime.now());
        outcomeOdd.setValidUntil(LocalDateTime.of(2019, 12, 24, 10, 30));
        outcome.addOutcomeOddToList(outcomeOdd);
        bet.addOutcomeToList(outcome);
        sportEvent.addBetToList(bet);
        sportEvents.add(sportEvent);

        sportEvent = new FootballSportEvent("Football Match - NOOB", LocalDateTime.of(2019, 10, 20, 20, 0), LocalDateTime.of(2019, 10, 20, 22, 0));
        bet = new Bet(BetType.WINNER);
        bet.setDescription("Bet02");
        outcome = new Outcome("Outcome1");
        outcomeOdd = new OutcomeOdd();
        outcomeOdd.setValue(BigDecimal.valueOf(150));
        outcomeOdd.setValidFrom(LocalDateTime.now());
        outcomeOdd.setValidUntil(LocalDateTime.of(2019, 11, 24, 13, 30));
        outcome.addOutcomeOddToList(outcomeOdd);
        bet.addOutcomeToList(outcome);
        sportEvent.addBetToList(bet);
        sportEvents.add(sportEvent);

        sportEvent = new TennisSportEvent("Tennis Challenge", LocalDateTime.of(2019, 11, 10, 10, 0), LocalDateTime.of(2019, 11, 10, 15, 0));
        bet = new Bet(BetType.PLAYERS_SCORE);
        bet.setDescription("Bet03");
        outcome = new Outcome("Outcome4");
        outcomeOdd = new OutcomeOdd();
        outcomeOdd.setValue(BigDecimal.valueOf(600));
        outcomeOdd.setValidFrom(LocalDateTime.now());
        outcomeOdd.setValidUntil(LocalDateTime.of(2019, 11, 24, 13, 30));
        outcome.addOutcomeOddToList(outcomeOdd);
        bet.addOutcomeToList(outcome);
        sportEvent.addBetToList(bet);
        sportEvents.add(sportEvent);
    }

    public void SavePlayer(Player player) {
        this.players.add(player);
    }

    public Player findPlayer() {
        return this.players.get(0);
    }

    public List<SportEvent> findAllSportEvents() {
        return this.sportEvents;
    }

    public boolean saveWager(Wager wager) {
        BigDecimal tempPlayerBalance = findPlayer().getBalance();
        BigDecimal wagerAmount = wager.getAmount();

        if (tempPlayerBalance.max(wagerAmount).equals(tempPlayerBalance)) {
            findPlayer().subtractValue(wagerAmount);
            this.wagers.add(wager);

            return true;
        }

        return false;
    }

    public List<Wager> findAllWagers() {
        return this.wagers;
    }

    private void generateResult() {
        for (Wager wager :
                wagers) {
            if (rnd.nextInt(3) == 1) {
                wager.setWin(true);
            }
        }
    }

    public void calculateResult() {
        generateResult();
        BigDecimal winValue = BigDecimal.valueOf(0);

        for (Wager wager : wagers) {
            if (wager.isWin()) {
                winValue = winValue.add(wager.getAmount().multiply(wager.getOutcomeOdd().getValue()));
            }
        }

        findPlayer().setBalance(winValue.add(findPlayer().getBalance()));
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (SportEvent sportEvent :
                sportEvents) {
            for (Bet bet :
                    sportEvent.getBets()
            ) {
                String betString = "Bet: " + bet.getBetType().toString() + " " + bet.getDescription();
                for (Outcome outcome :
                        bet.getOutcomes()) {
                    String outcomeString = "Outcome: " + outcome.getDescription();
                    for (OutcomeOdd outcomeOdd :
                            outcome.getOutcomeOdds()) {
                        output.append(sportEvent.toString()).append(", ").append(bet.toString()).append(", ").append(outcome.toString()).append(", ").append(outcomeOdd.getDatas()).append("\n");
                    }
                }
            }
        }

        return output.toString();
    }
}
