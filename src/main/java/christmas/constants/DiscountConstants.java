package christmas.constants;

public enum DiscountConstants {
    NOTHING(0L),
    MINIMUM_CHRISTMAS_DISCOUNT(1000L),
    CHRISTMAS_DAILY_DISCOUNT(100L),
    GIVEAWAY_EVENT(25000L)
    ;

    private final Long value;

    DiscountConstants(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
