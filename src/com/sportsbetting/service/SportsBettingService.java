package com.sportsbetting.service;

import com.sportsbetting.model.Player;
import com.sportsbetting.model.SportEvent;
import com.sportsbetting.model.Wager;

import java.util.ArrayList;
import java.util.List;

public class SportsBettingService {
    private List<Player> players;
    private List<SportEvent> sportEvents;
    private List<Wager> wagers;

    public SportsBettingService() {
        this.players = new ArrayList<>();
        this.sportEvents = new ArrayList<>();
        this.wagers = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<SportEvent> getSportEvents() {
        return this.sportEvents;
    }

    public List<Wager> getWagers() {
        return this.wagers;
    }

    public void Inizialize(){
        this.sportEvents.add(new SportEvent("Test Match"));
    }

    public void SavePlayer(Player player) {
        this.players.add(player);
    }

    public Player findPlayer() {
        return this.players.get(0);
    }

    public List<SportEvent> findAllSportEvents() {
        return this.sportEvents;
    }

    public void saveWager(Wager wager) {
        this.wagers.add(wager);
    }

    public List<Wager> findAllWagers() {
        return this.wagers;
    }

    public void calculateResult() {

    }
}
