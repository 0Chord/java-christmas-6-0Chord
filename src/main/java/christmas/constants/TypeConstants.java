package christmas.constants;

public enum TypeConstants {
    APPETIZER("에피타이저"),
    BEVERAGE("탄산음료"),
    DESSERT("디저트"),
    MAIN("메인메뉴"),
    WEEKDAY("weekday"),
    WEEKEND("weekend"),
    SPECIAL_DAY("special"),
    CHRISTMAS("christmas"),
    DASH("-"),
    COMMAS(","),
    UNIT_OF_MONEY("###,###원"),
    ;

    private final String name;

    TypeConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
