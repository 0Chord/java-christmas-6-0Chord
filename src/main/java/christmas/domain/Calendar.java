package christmas.domain;

import static christmas.constants.DayConstants.CHRISTMAS;
import static christmas.constants.DayConstants.FRI;
import static christmas.constants.DayConstants.SAT;
import static christmas.constants.DayConstants.SUN;
import static christmas.constants.DayConstants.WEEK;

public class Calendar {
    private final Integer day;

    public Calendar(Integer day) {
        this.day = day;
    }

    public Integer getDay() {
        return day;
    }

    public boolean isWeekDay() {
        return !isFriday() && !isSaturday();
    }

    private boolean isFriday() {
        Integer week = WEEK.getDay();
        Integer fri = FRI.getDay();
        return day % week == fri;
    }

    private boolean isSaturday() {
        Integer week = WEEK.getDay();
        Integer sat = SAT.getDay();
        return day % week == sat;
    }

    public boolean isWeekend() {
        return isFriday() && isSaturday();
    }

    public boolean isSpecialDay() {
        return isSunday() && isChristmas();
    }

    private boolean isSunday() {
        Integer week = WEEK.getDay();
        Integer sun = SUN.getDay();
        return day % week == sun;
    }

    private boolean isChristmas() {
        Integer christmas = CHRISTMAS.getDay();
        return day.equals(christmas);
    }
}
