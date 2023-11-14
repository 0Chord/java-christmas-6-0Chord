package christmas.constants.menu;

import christmas.vo.Menu;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>();
        for (Beverage beverage : Beverage.values()) {
            String getMenu = beverage.getMenu();
            Integer price = beverage.getPrice();
            Menu menu = new Menu(getMenu, price);
            menus.add(menu);
        }
        return menus;
    }

    private String getMenu() {
        return menu;
    }

    private Integer getPrice() {
        return price;
    }
}
