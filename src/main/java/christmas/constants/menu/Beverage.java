package christmas.constants.menu;

import java.util.Arrays;

public enum Beverage {

    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 6000),
    CHAMPAGNE("샴페인", 25000);

    private final String menu;
    private final Integer price;

    Beverage(String menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public static boolean isMatch(String name) {
        return Arrays.stream(Beverage.values())
                .anyMatch(type -> type.menu.equals(name));
    }
}
