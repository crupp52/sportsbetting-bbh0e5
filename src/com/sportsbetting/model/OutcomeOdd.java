package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOdd {
    private BigDecimal value;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private Outcome outcome;

    public OutcomeOdd() {
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
}
