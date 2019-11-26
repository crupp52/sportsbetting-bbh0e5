package com.example.sportsbetting.domain;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class TennisSportEvent extends SportEvent {
    public TennisSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
        super(title, startDate, endDate);
    }
}
