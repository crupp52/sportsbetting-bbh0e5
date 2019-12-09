package com.example.sportsbetting.viewHelper;

public class WagerInfoHelper {
    private Integer id;
    private String eventTitle;
    private String eventType;
    private String betType;
    private String outcomeValue;
    private String outcomeOdd;
    private String wagerAmount;
    private String winner;
    private String processed;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public void setOutcomeValue(String outcomeValue) {
        this.outcomeValue = outcomeValue;
    }

    public void setOutcomeOdd(String outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
    }

    public void setWagerAmount(String wagerAmount) {
        this.wagerAmount = wagerAmount;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public Integer getId() {
        return id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventType() {
        return eventType;
    }

    public String getBetType() {
        return betType;
    }

    public String getOutcomeValue() {
        return outcomeValue;
    }

    public String getOutcomeOdd() {
        return outcomeOdd;
    }

    public String getWagerAmount() {
        return wagerAmount;
    }

    public String getWinner() {
        return winner;
    }

    public String getProcessed() {
        return processed;
    }

    public boolean isProcessed() {
        return !processed.equals("No");
    }
}