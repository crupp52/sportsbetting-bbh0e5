package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Outcome {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    @ManyToOne
    private Bet bet;
    @ElementCollection
    private List<OutcomeOdd> outcomeOdds;

    public Outcome(String description) {
        this.description = description;
        this.outcomeOdds = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOutcomeOdds(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
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
