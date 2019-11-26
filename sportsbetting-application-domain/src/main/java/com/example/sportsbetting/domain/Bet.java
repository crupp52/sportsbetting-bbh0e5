package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bet {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    @ElementCollection
    private List<Outcome> outcomes;
    @OneToOne
    private SportEvent sportEvent;
    @Enumerated
    private BetType betType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

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
