package pruebas;

import java.math.BigDecimal;

public class Asset {
    private Long id;
    private String name;
    private BigDecimal priceAsset;

    public Asset() {
    }

    public Asset(Long id, String name, BigDecimal priceAsset) {
        this.id = id;
        this.name = name;
        this.priceAsset = priceAsset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return  "\n{id: " + getId() + ", " +
                " Name: " + getName() + ", " +
                " Price: " + getPriceAsset() + "}";
    }
}
