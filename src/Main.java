package pruebas;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void printPriceAsset(User user) {
        user.getAssetsList()
                .stream()
                .map(Assets::getPriceAsset)
                .forEach(System.out::println);
    }

    public static void applyTaxList(User user) {
        user.getAssetsList()
                .stream()
                .peek(assets -> assets.setPriceAsset(BigDecimal.valueOf(1.25).multiply(assets.getPriceAsset())))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
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

        Wallet wallet1 = new Wallet(BigDecimal.valueOf(10000), assetsList0);

        User user = new User("Jose","Linares", LocalDateTime.now(), wallet1, assetsList0);

        System.out.println("--------------------------");
        printPriceAsset(user);
        System.out.println("--------------------------");
        System.out.println(user);;
    }
}
