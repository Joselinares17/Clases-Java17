package pruebas;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Assets {
    private String name;
    private BigDecimal priceAsset;
    private LocalDateTime localDateTime;

    public Assets(String name, BigDecimal priceAsset, LocalDateTime localDateTime) {
        this.name = name;
        this.priceAsset = priceAsset;
        this.localDateTime = localDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPriceAsset() {
        return priceAsset;
    }

    public void setPriceAsset(BigDecimal priceAsset) {
        this.priceAsset = priceAsset;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return  "\nName: " + getName() +
                "\nPrice: " + getPriceAsset() +
                "\nPushed date: " +getLocalDateTime();
    }
}
