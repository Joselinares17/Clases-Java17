package pruebas;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private String lastName;
    private LocalDateTime accountCreatedDate;
    private Wallet walletFound;
    private List<Assets> assetsList;
    private BigDecimal valueAssets;

    public User() {
    }

    public User(String name, String lastName, LocalDateTime accountCreatedDate, Wallet walletFound, List<Assets> assetsList) {
        this.name = name;
        this.lastName = lastName;
        this.accountCreatedDate = accountCreatedDate;
        this.walletFound = walletFound;
        this.assetsList = assetsList;
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

    public Wallet getWalletFound() {
        return walletFound;
    }

    public void setWalletFound(Wallet walletFound) {
        this.walletFound = walletFound;
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    public BigDecimal getValueAssets() {
        return valueAssets;
    }

    public void setValueAssets(BigDecimal valueAssets) {
        this.valueAssets = valueAssets;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nLastname: " + getLastName() +
                "\nCreated date: " + getAccountCreatedDate() +
                "\nWallet: " + getWalletFound() +
                "\nAssets: " + getAssetsList();
    }
}
