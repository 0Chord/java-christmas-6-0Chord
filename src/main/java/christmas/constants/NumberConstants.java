package christmas.constants;

public enum NumberConstants {

    NOTHING(0),
    ONE(1),
    SANTA(20000),
    TREE(10000),
    STAR(5000),
    MAX_ORDER_COUNT(20),
    MINIMUM_DISCOUNT_ORDER_PRICE(10000),
    DAILY_DISCOUNT(2023),
    GIVEAWAY_EVENT_MINIMUM_PRICE(120000)
    ;

    private final Integer value;

    NumberConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
