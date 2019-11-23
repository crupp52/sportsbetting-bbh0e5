package com.sportsbetting.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOdd {
    private BigDecimal value;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private Outcome outcome;

    public OutcomeOdd() {
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Outcome getOutcome() {
        return this.outcome;
    }

    public String getDatas() {
        return "Actual odd: " + value + ", Valid between " + validFrom.toString() + " and " + validUntil.toString() + ".";
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }
}
