package com.example.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

public class Outcome {
    private String description;
    private Bet bet;
    private List<OutcomeOdd> outcomeOdds;

    public Outcome(String description) {
        this.description = description;
        this.outcomeOdds = new ArrayList<>();
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addOutcomeOddToList(OutcomeOdd outcomeOdd) {
        outcomeOdd.setOutcome(this);
        this.outcomeOdds.add(outcomeOdd);
    }

    public Bet getBet() {
        return bet;
    }

    public String getDescription() {
        return description;
    }

    public List<OutcomeOdd> getOutcomeOdds() {
        return this.outcomeOdds;
    }

    @Override
    public String toString() {
        return "Outcome: " + description;
    }
}
