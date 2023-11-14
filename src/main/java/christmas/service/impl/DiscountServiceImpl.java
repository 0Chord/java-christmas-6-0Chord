package christmas.service.impl;

import static christmas.constants.TypeConstants.CHRISTMAS;
import static christmas.constants.TypeConstants.DESSERT;
import static christmas.constants.TypeConstants.MAIN;
import static christmas.constants.TypeConstants.SPECIAL_DAY;
import static christmas.constants.TypeConstants.WEEKDAY;
import static christmas.constants.TypeConstants.WEEKEND;

import christmas.domain.Calendar;
import christmas.domain.Order;
import christmas.service.DiscountService;
import christmas.vo.Discount;

public class DiscountServiceImpl implements DiscountService {
    @Override
    public Discount christmas(Calendar calendar) {
        if (calendar.isLessEqualThanChristmasDay()) {
            Integer day = calendar.getDay();
            long amount = calcDiscount(day);
            return new Discount(CHRISTMAS.getName(), amount);
        }
        return new Discount(CHRISTMAS.getName(), 0L);
    }

    private long calcDiscount(Integer day) {
        return 1000L + (day - 1) * 100L;
    }

    public Discount date(Calendar calendar, Order order) {
        if (calendar.isWeekDay()) {
            return weekday(order);
        }
        return weekend(order);
    }

    private Discount weekday(Order order) {
        Long quantity = order.getCountQuantityFromCategory(DESSERT.getName());
        return new Discount(WEEKDAY.getName(), quantity * 2023);

    }

    private Discount weekend(Order order) {
        Long quantity = order.getCountQuantityFromCategory(MAIN.getName());
        return new Discount(WEEKEND.getName(), quantity * 2023);
    }

    @Override
    public Discount specialDay(Calendar calendar) {
        if (calendar.isSpecialDay()) {
            return new Discount(SPECIAL_DAY.getName(), 1000L);
        }
        return new Discount(SPECIAL_DAY.getName(), 0L);
    }


}
