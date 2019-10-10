package com.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportEvent {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Bet> bets;
    private Result result;

    public SportEvent(){
        this.bets = new ArrayList<Bet>();
    }

    public void addBetToList(Bet bet){
        bet.setSportEvent(this);
        bets.add(bet);
    }
}
