package christmas.menu;


import java.util.Arrays;

public enum Appetizer {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAL_SALAD("시저샐러드", 8000);

    private final String menu;
    private final Integer price;

    Appetizer(String menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public static boolean isMatch(String name) {
        return Arrays.stream(Appetizer.values())
                .anyMatch(type -> type.menu.equals(name));
    }
}
