package com.sportsbetting.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportEvent {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Bet> bets;
    private Result result;

    public SportEvent(String title) {
        this.title = title;
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
        return "Sport Event: " + this.getTitle() + "(start: " + this.startDate.toString() + ")";
    }
}
