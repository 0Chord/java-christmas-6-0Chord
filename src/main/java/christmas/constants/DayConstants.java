package christmas.constants;

public enum DayConstants {

    WEEK(7),
    FRI(1),
    SAT(2),
    SUN(3),
    CHRISTMAS(25),
    LAST_DAY(31),
    FIRST_DAY(1)
    ;

    private Integer day;

    DayConstants(Integer day) {
        this.day = day;
    }


    public Integer getDay() {
        return day;
    }
}
