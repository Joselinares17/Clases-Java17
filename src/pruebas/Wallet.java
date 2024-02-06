package pruebas;

import java.math.BigDecimal;
import java.util.List;

public class Wallet {
    private BigDecimal totalFound;
    private BigDecimal assetFound;
    private BigDecimal liquidFound;
    private Integer countAssets;
    private List<Assets> assetsList;

    public Wallet(BigDecimal totalFound, List<Assets> assetsList) {
        this.totalFound = totalFound;
        this.assetFound = BigDecimal.valueOf(0);
        this.liquidFound = BigDecimal.valueOf(0);
        this.assetsList = assetsList;
    }

    public BigDecimal getTotalFound() {
        return totalFound;
    }

    public void setTotalFound(BigDecimal totalFound) {
        this.totalFound = totalFound;
    }

    public BigDecimal getAssetFound() {
        return assetsList.stream()
                .map(Assets::getPriceAsset)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setAssetFound(BigDecimal assetFound) {
        this.assetFound = assetFound;
    }

    public BigDecimal getLiquidFound() {
        return totalFound.subtract(getAssetFound());
    }

    public void setLiquidFound(BigDecimal liquidFound) {
        this.liquidFound = liquidFound;
    }

    public Integer getCountAssets() {
        return this.assetsList.size();
    }

    public void setCountAssets(Integer countAssets) {
        this.countAssets = countAssets;
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    @Override
    public String toString() {
        return  "\ntotalFound: " + getTotalFound() +
                "\nassetFound: " + getAssetFound() +
                "\nliquidFound: " + getLiquidFound() +
                "\nassetsList: " + getAssetsList();
    }
}
