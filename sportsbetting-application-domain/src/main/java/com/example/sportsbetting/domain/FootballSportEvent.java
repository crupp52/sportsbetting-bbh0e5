package com.example.sportsbetting.domain;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class FootballSportEvent extends SportEvent {
    public FootballSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
        super(title, startDate, endDate);
    }
}
