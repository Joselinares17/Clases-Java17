package pruebas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enterprice {
    private String name;
    private String description;
    private TypeEnterprice typeEnterprice;
    private Integer quanAssetOffered;
    private BigDecimal valuePerAsset;
    private BigDecimal marketValue;
    private List<Asset> assetList;

    public Enterprice() {
        this.quanAssetOffered = 0;
        this.marketValue = BigDecimal.ZERO;
    }

    public Enterprice(String name, String description, TypeEnterprice typeEnterprice, BigDecimal valuePerAsset, List<Asset> assetList) {
        this();
        this.name = name;
        this.description = description;
        this.typeEnterprice = typeEnterprice;
        this.valuePerAsset = valuePerAsset;
        this.assetList = assetList;
    }

    public Enterprice(String name, String description, TypeEnterprice typeEnterprice, BigDecimal valuePerAsset) {
        this();
        this.name = name;
        this.description = description;
        this.typeEnterprice = typeEnterprice;
        this.valuePerAsset = valuePerAsset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeEnterprice getTypeEnterprice() {
        return typeEnterprice;
    }

    public void setTypeEnterprice(TypeEnterprice typeEnterprice) {
        this.typeEnterprice = typeEnterprice;
    }

    public Integer getQuanAssetOffered() {
        return this.assetList.size();
    }

    public void setQuanAssetOffered(Integer quanAssetOffered) {
        this.quanAssetOffered = quanAssetOffered;
    }

    public BigDecimal getValuePerAsset() {
        return valuePerAsset;
    }

    public void setValuePerAsset(BigDecimal valuePerAsset) {
        this.valuePerAsset = valuePerAsset;
    }

    public BigDecimal getMarketValue() {
        return calculateMarketValue();
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public List<Asset> getAssetsList() {
        return assetList;
    }

    public void setAssetsList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    private BigDecimal calculateMarketValue() {
        return this.valuePerAsset.multiply(BigDecimal.valueOf(getQuanAssetOffered()));
    }

    public Asset sellAsset() {
        Random rand = new Random();
        Asset tempAsset = this.assetList.get(rand.nextInt(this.assetList.size()));
        this.assetList.remove(rand.nextInt(this.assetList.size()));
        this.quanAssetOffered--;
        return tempAsset;
    }

    public Asset sellAssetById(Long id) {
        //Asset tempAsset = this.assetList.get(id.intValue());
        Asset tempAsset = this.assetList.stream()
                .filter(asset -> asset.getId().equals(id))
                .findFirst()
                .orElseThrow();
        this.assetList.remove(tempAsset);
        this.quanAssetOffered--;
        return tempAsset;
    }

    @Override
    public String toString() {
        return  "\nname: " + name +
                "\ndescription: " + description +
                "\ntypeEnterprice: " + typeEnterprice +
                "\ncantAssetsOffered: " + getQuanAssetOffered() +
                "\nmarketValue: " + getMarketValue() +
                "\nassetList: " + assetList;
    }
}
