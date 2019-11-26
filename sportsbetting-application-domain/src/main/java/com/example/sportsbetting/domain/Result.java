package com.example.sportsbetting.domain;

import javax.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private Outcome outcome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Result() {
    }
}
