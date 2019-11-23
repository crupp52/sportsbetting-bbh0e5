package com.example.sportsbetting.domain;

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

    public Wager(BigDecimal amount, Player player, OutcomeOdd outcomeOdd) {
        this.amount = amount;
        this.player = player;
        this.currency = player.getCurrency();
        this.outcomeOdd = outcomeOdd;

        timestampCreated = LocalDateTime.now();
        processed = true;
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

    public String getResultString() {
        return "Wager '" + outcomeOdd.getOutcome().getBet().getBetType().toString() + " " + outcomeOdd.getOutcome().getBet().getDescription() + "=" + outcomeOdd.getOutcome().getDescription() + "' of " + outcomeOdd.getOutcome().getBet().getEvent().getTitle() + " [odd: " + outcomeOdd.getValue() + ", amount: " + amount + "], win: " + win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isWin() {
        return win;
    }

    public Player getPlayer() {
        return player;
    }
}
