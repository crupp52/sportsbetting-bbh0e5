package com.sportsbetting.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {
    private BigDecimal amount;
    private LocalDateTime timestampCreated;
    private boolean processed;
    private boolean win;
    private OutcomeOdd outcomeOdd;
    private Player player;
    private Currency currency;

    public Wager() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public OutcomeOdd getOutcomeOdd() {
        return this.outcomeOdd;
    }

    @Override
    public String toString() {
        return this.outcomeOdd.getOutcome().getBet().getBetType().toString();
    }
}
