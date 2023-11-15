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
    NOTHING("없음"),
    SANTA("산타"),
    TREE("트리"),
    STAR("별"),
    UNIT_OF_ORDERS("%s %s개"),
    BLANK("")
    ;

    private final String name;

    TypeConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
