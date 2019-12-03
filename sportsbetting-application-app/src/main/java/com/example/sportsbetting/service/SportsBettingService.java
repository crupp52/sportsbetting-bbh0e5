package com.example.sportsbetting.service;

import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.viewHelper.WagerInfoHelper;

import java.util.List;

public interface SportsBettingService {
    boolean Login(String name, String password);
    Player getLoggedInUser();
    List<Wager> getLoggedInUserWagers();
    List<WagerInfoHelper> getWagerInfos();
    void savePlayer(Player player);
}
