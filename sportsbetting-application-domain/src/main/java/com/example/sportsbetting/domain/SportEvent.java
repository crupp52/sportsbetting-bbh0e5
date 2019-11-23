package com.example.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportEvent {
    public List<OutcomeOdd> get;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Bet> bets;
    private Result result;

    public SportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;

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
