package christmas.vo;

import java.util.Objects;

public class Discount {

    private final String category;
    private final Long amount;

    public Discount(String category, Long amount) {
        this.category = category;
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public boolean isCategory(String category) {
        return Objects.equals(this.category, category);
    }
}
