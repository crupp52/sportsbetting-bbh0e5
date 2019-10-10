package com.model;

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
}
