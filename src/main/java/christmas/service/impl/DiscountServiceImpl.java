package christmas.service.impl;

import static christmas.constants.DiscountConstants.CHRISTMAS_DAILY_DISCOUNT;
import static christmas.constants.DiscountConstants.MINIMUM_CHRISTMAS_DISCOUNT;
import static christmas.constants.DiscountConstants.NOTHING;
import static christmas.constants.NumberConstants.DAILY_DISCOUNT;
import static christmas.constants.NumberConstants.ONE;
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
        return new Discount(CHRISTMAS.getName(), NOTHING.getValue());
    }

    private long calcDiscount(Integer day) {
        return MINIMUM_CHRISTMAS_DISCOUNT.getValue() + (day - ONE.getValue()) * CHRISTMAS_DAILY_DISCOUNT.getValue();
    }

    public Discount date(Calendar calendar, Order order) {
        if (calendar.isWeekDay()) {
            return weekday(order);
        }
        return weekend(order);
    }

    private Discount weekday(Order order) {
        Long quantity = order.getCountQuantityFromCategory(DESSERT.getName());
        return new Discount(WEEKDAY.getName(), quantity * DAILY_DISCOUNT.getValue());

    }

    private Discount weekend(Order order) {
        Long quantity = order.getCountQuantityFromCategory(MAIN.getName());
        return new Discount(WEEKEND.getName(), quantity * DAILY_DISCOUNT.getValue());
    }

    @Override
    public Discount specialDay(Calendar calendar) {
        if (calendar.isSpecialDay()) {
            return new Discount(SPECIAL_DAY.getName(), MINIMUM_CHRISTMAS_DISCOUNT.getValue());
        }
        return new Discount(SPECIAL_DAY.getName(), NOTHING.getValue());
    }


}
