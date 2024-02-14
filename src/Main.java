package pruebas;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void printPriceAsset(Wallet wallet) {
        wallet.getAssetsList()
                .stream()
                .map(Asset::getPriceAsset)
                .forEach(System.out::println);
    }

    public static void applyTaxList(Wallet wallet) {
        wallet.getAssetsList()
                .stream()
                .peek(asset -> asset.setPriceAsset(BigDecimal.valueOf(1.25).multiply(asset.getPriceAsset())))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Enterprice enterprice0 = new Enterprice("Apple", "Electronic devices", TypeEnterprice.TECH, BigDecimal.valueOf(150));

        List<Asset> assetList = new ArrayList<>(Arrays.asList(
                new Asset(1L, enterprice0.getName(), enterprice0.getValuePerAsset()),
                new Asset(2L, enterprice0.getName(), enterprice0.getValuePerAsset()),
                new Asset(3L, enterprice0.getName(), enterprice0.getValuePerAsset()),
                new Asset(4L, enterprice0.getName(), enterprice0.getValuePerAsset()),
                new Asset(5L, enterprice0.getName(), enterprice0.getValuePerAsset())
        ));
        enterprice0.setAssetsList(assetList);

        List<Asset> assetListCopy = new ArrayList<>();

        Wallet wallet0 = new Wallet(BigDecimal.valueOf(10000), assetListCopy);

        User user0 = new User("José", "Linares", LocalDateTime.now(), wallet0);

        System.out.println("Datos enterprice " + enterprice0);
        System.out.println("------------------------------------");
        System.out.println("Datos wallet " + wallet0);
        System.out.println("------------------------------------");
        System.out.println("Datos usuario " + user0);

        user0.buyAsset(enterprice0.sellAssetById(1L));
        user0.buyAsset(enterprice0.sellAssetById(2L));

        System.out.println("---------------new object---------------------");
        System.out.println("Datos enterprice " + enterprice0);
        System.out.println("------------------------------------");
        System.out.println("Datos wallet " + wallet0);
        System.out.println("------------------------------------");
        System.out.println("Datos usuario " + user0);
    }

    /*
    List<Assets> assetsList0 = Arrays.asList(
                new Assets("Apple", BigDecimal.valueOf(125), LocalDateTime.of(2018,8,20,12,50)),
                new Assets("AMD", BigDecimal.valueOf(245), LocalDateTime.of(2020, 1, 1, 9, 30)),
                new Assets("Intel", BigDecimal.valueOf(150), LocalDateTime.of(2019, 5, 15, 18, 45)),
                new Assets("Microsoft", BigDecimal.valueOf(300), LocalDateTime.of(2022, 3, 10, 14, 15)),
                new Assets("NVIDIA", BigDecimal.valueOf(180), LocalDateTime.of(2021, 7, 5, 11, 0))
        );

        List<Assets> assetsList1 = Arrays.asList(
                new Assets("Amazon", BigDecimal.valueOf(2000), LocalDateTime.of(2023, 6, 28, 10, 30)),
                new Assets("Facebook", BigDecimal.valueOf(350), LocalDateTime.of(2022, 9, 15, 16, 45)),
                new Assets("Tesla", BigDecimal.valueOf(700), LocalDateTime.of(2023, 2, 5, 13, 0)),
                new Assets("Qualcomm", BigDecimal.valueOf(120), LocalDateTime.of(2021, 11, 20, 9, 0)),
                new Assets("Alibaba", BigDecimal.valueOf(250), LocalDateTime.of(2022, 5, 3, 14, 20))
        );
    */
}
