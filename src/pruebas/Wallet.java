package pruebas;

import java.math.BigDecimal;
import java.util.List;

public class Wallet {
    private BigDecimal totalFound;
    private BigDecimal assetFound;
    private BigDecimal liquidFound;
    private Integer countAssets;
    private List<Asset> assetList;

    public Wallet() {
        this.assetFound = BigDecimal.valueOf(0);
        this.liquidFound = BigDecimal.valueOf(0);
    }

    public Wallet(BigDecimal totalFound, List<Asset> assetList) {
        this();
        this.totalFound = totalFound;
        this.assetList = assetList;
    }

    public Wallet(BigDecimal totalFound) {
        this();
        this.totalFound = totalFound;
    }

    public BigDecimal getTotalFound() {
        return totalFound;
    }

    public void setTotalFound(BigDecimal totalFound) {
        this.totalFound = totalFound;
    }

    public BigDecimal getAssetFound() {
        return assetList.stream()
                .map(Asset::getPriceAsset)
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
        return this.assetList.size();
    }

    public void setCountAssets(Integer countAssets) {
        this.countAssets = countAssets;
    }

    public List<Asset> getAssetsList() {
        return assetList;
    }

    public void setAssetsList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    @Override
    public String toString() {
        return  "\ntotalFound: " + getTotalFound() +
                "\nassetFound: " + getAssetFound() +
                "\nliquidFound: " + getLiquidFound() +
                "\nassetsList: " + getAssetsList();
    }
}
