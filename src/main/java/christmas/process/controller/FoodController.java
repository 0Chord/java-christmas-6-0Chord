package christmas.process.controller;

import static christmas.constants.TypeConstants.APPETIZER;
import static christmas.constants.TypeConstants.BEVERAGE;
import static christmas.constants.TypeConstants.DESSERT;
import static christmas.constants.TypeConstants.MAIN;

import christmas.constants.TypeConstants;
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
        categories.add(new Category(APPETIZER.getName(), Appetizer.getMenus()));
        categories.add(new Category(BEVERAGE.getName(), Beverage.getMenus()));
        categories.add(new Category(DESSERT.getName(), Dessert.getMenus()));
        categories.add(new Category(MAIN.getName(), Main.getMenus()));
        return new Food(categories);
    }
}
