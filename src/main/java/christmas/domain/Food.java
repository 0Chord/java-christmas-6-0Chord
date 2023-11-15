package christmas.domain;

import christmas.vo.Category;
import christmas.vo.Menu;
import java.util.List;

public class Food {
    private final List<Category> categories;

    public Food(List<Category> categories) {
        this.categories = categories;
    }

    public boolean isMatch(String category, String menu) {
        return categories.stream()
                .filter(type -> category.equals(type.getCategory()))
                .anyMatch(type -> type.getMenus().contains(menu));
    }

    public Integer getPrice(String category, String menu) {
        return categories.stream()
                .filter(type -> category.equals(type.getCategory()))
                .flatMap(type -> type.menus().stream())
                .filter(menuName -> menu.equals(menuName.getMenu()))
                .findFirst()
                .map(Menu::getPrice)
                .orElse(0);
    }
}
