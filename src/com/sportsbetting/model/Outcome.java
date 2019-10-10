package model;

import java.util.List;

public class Outcome {
    private String description;
    private Bet bet;
    private List<OutcomeOdd> outcomeOdds;

    public Outcome(){

    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public void addOutcomeOddToList(OutcomeOdd outcomeOdd) {
        outcomeOdd.setOutcome(this);
        this.outcomeOdds.add(outcomeOdd);
    }
}
