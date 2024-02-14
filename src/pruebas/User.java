package pruebas;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class User {
    private String name;
    private String lastName;
    private LocalDateTime accountCreatedDate;
    private Wallet wallet;
    private BigDecimal valueAssets;

    public User() {
    }

    public User(String name, String lastName, LocalDateTime accountCreatedDate, Wallet wallet) {
        this.name = name;
        this.lastName = lastName;
        this.accountCreatedDate = accountCreatedDate;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public void setAccountCreatedDate(LocalDateTime accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public BigDecimal getValueAssets() {
        return valueAssets;
    }

    public void setValueAssets(BigDecimal valueAssets) {
        this.valueAssets = valueAssets;
    }

    @Override
    public String toString() {
        return "\nName: " + getName() +
                "\nLastname: " + getLastName() +
                "\nCreated date: " + getAccountCreatedDate() +
                "\nWallet: " + getWallet();
    }
}
