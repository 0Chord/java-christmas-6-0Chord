package christmas.vo;

import java.util.List;

public final class Category {

    private final String category;
    private final List<Menu> menus;

    public Category(String category, List<Menu> menus) {
        this.category = category;
        this.menus = menus;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return menus.stream()
                .map(Menu::getMenu)
                .toList();
    }

    public List<Menu> menus() {
        return menus;
    }
}
