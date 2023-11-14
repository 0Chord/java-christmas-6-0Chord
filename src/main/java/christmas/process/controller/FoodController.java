package christmas.process.controller;

import christmas.constants.menu.Appetizer;
import christmas.constants.menu.Beverage;
import christmas.constants.menu.Dessert;
import christmas.constants.menu.Main;
import christmas.domain.Food;
import christmas.vo.Category;
import java.util.ArrayList;
import java.util.List;

public class FoodController {

    public Food make() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("에피타이저", Appetizer.getMenus()));
        categories.add(new Category("탄산음료", Beverage.getMenus()));
        categories.add(new Category("디저트", Dessert.getMenus()));
        categories.add(new Category("메인메뉴", Main.getMenus()));
        return new Food(categories);
    }
}
