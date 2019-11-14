package com.sportsbetting.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player extends User {
    private String name;
    private Integer accountNumber;
    private BigDecimal balance;
    private LocalDate birth;
    private Currency currency;

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void subtractValue(BigDecimal wagerAmount) {
        this.balance = this.balance.subtract(wagerAmount);
    }
}
