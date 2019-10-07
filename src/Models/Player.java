package Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player extends User {
    private String name;
    private Integer accountNumber;
    private BigDecimal balance;
    private LocalDate birth;

    public Player(String email, String password, String name, Integer accountNumber, BigDecimal balance, LocalDate birth) {
        super(email, password);
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.birth = birth;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;

    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getName() {
        return name;
    }
}
