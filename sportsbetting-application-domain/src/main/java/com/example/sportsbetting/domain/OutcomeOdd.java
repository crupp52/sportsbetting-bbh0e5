package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OutcomeOdd {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal value;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    @ManyToOne
    private Outcome outcome;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
