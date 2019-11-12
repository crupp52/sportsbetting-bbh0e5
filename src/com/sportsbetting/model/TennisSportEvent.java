package com.sportsbetting.model;

import java.time.LocalDateTime;

public class TennisSportEvent extends SportEvent {
    public TennisSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate) {
        super(title, startDate, endDate);
    }
}
