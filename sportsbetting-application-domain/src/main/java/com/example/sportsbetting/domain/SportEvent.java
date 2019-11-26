package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SportEvent {
    @Id
    @GeneratedValue
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Bet> bets;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Result result;

    public SportEvent() {
        this.result = new Result();
        this.bets = new ArrayList<>();
    }

    public void addBetToList(Bet bet) {
        bet.setSportEvent(this);
        bets.add(bet);
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Sport event: " + title + " (Start: " + startDate.toString() + ")";
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Bet> getBets() {
        return this.bets;
    }
}
