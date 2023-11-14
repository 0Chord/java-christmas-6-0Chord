package christmas.service.impl;

import christmas.constants.menu.Dessert;
import christmas.constants.menu.Main;
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
            return new Discount("christmas", amount);
        }
        return new Discount("christmas", 0L);
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
        Long quantity = order.getCountQuantityFromCategory("디저트");
        return new Discount("weekday", quantity * 2023);

    }

    private Discount weekend(Order order) {
        Long quantity = order.getCountQuantityFromCategory("메인메뉴");
        return new Discount("weekend", quantity * 2023);
    }

    @Override
    public Discount specialDay(Calendar calendar) {
        if (calendar.isSpecialDay()) {
            return new Discount("special", 1000L);
        }
        return new Discount("special", 0L);
    }


}
