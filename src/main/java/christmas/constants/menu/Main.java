package christmas.constants.menu;

import christmas.vo.Menu;
import java.util.ArrayList;
import java.util.List;

public enum Main {
    T_BONE_STAKE("티본스테이크", 55000),
    BARBEQUE_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private final String menu;
    private final Integer price;

    Main(String menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public static List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>();
        for (Main main : Main.values()) {
            String getMenu = main.getMenu();
            Integer price = main.getPrice();
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
