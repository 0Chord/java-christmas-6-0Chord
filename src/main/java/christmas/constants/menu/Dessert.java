package christmas.constants.menu;

import christmas.vo.Menu;
import java.util.ArrayList;
import java.util.List;

public enum Dessert {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String menu;
    private final Integer price;

    Dessert(String menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public static List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>();
        for (Dessert dessert : Dessert.values()) {
            String getMenu = dessert.getMenu();
            Integer price = dessert.getPrice();
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
