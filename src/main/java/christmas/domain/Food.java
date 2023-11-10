package christmas.domain;

import christmas.vo.Category;
import java.util.List;

public class Food {
    private List<Category> categories;

    public Food(List<Category> categories) {
        this.categories = categories;
    }
}
