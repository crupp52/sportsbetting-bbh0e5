package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Wager {
    @Id
    @GeneratedValue
    private int id;
    private BigDecimal amount;
    private LocalDateTime timestampCreated;
    private boolean processed;
    private boolean win;
    @OneToOne
    private OutcomeOdd outcomeOdd;
    @OneToOne
    private Player player;
    @Enumerated
    private Currency currency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public void setOutcomeOdd(OutcomeOdd outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Wager() {
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
