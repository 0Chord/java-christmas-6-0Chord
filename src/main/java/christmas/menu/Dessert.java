package christmas.menu;

import java.util.Arrays;

public enum Dessert {

    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String menu;
    private final Integer price;

    Dessert(String menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public static boolean isMatch(String name) {
        return Arrays.stream(Dessert.values())
                .anyMatch(type -> type.menu.equals(name));
    }
}
