package com.sportsbetting.model;

import java.util.ArrayList;
import java.util.List;

public class Bet {
    private String description;
    private List<Outcome> outcomes;
    private SportEvent sportEvent;
    private BetType betType;

    public Bet(BetType betType) {
        this.betType = betType;

        this.outcomes = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public SportEvent getEvent() {
        return sportEvent;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void addOutcomeToList(Outcome outcome) {
        outcome.setBet(this);
        this.outcomes.add(outcome);
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public BetType getBetType() {
        return betType;
    }

    @Override
    public String toString() {
        return "Bet: " + betType.toString() + " " + description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
