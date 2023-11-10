package christmas.constants.menu;

import java.util.Arrays;

public enum Main {
    T_BONE_STAKE("티본스테이크", 55000),
    BARBEQUE_RIBS("바베큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private final String menu;
    private final Integer price;

    Main(String menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public static boolean isMatch(String name) {
        return Arrays.stream(Main.values())
                .anyMatch(type -> type.menu.equals(name));
    }
}
