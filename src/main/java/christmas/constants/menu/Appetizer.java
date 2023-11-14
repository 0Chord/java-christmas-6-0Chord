package christmas.constants.menu;


import christmas.vo.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Appetizer {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAL_SALAD("시저샐러드", 8000);

    private final String menu;
    private final Integer price;

    private String getMenu() {
        return menu;
    }

    private Integer getPrice() {
        return price;
    }

    Appetizer(String menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public static List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>();
        for (Appetizer appetizer : Appetizer.values()) {
            String getMenu = appetizer.getMenu();
            Integer price = appetizer.getPrice();
            Menu menu = new Menu(getMenu, price);
            menus.add(menu);
        }
        return menus;
    }
}