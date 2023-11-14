package christmas.service;

import christmas.domain.Calendar;
import christmas.domain.Order;
import christmas.vo.Discount;

public interface DiscountService {

    Discount christmas(Calendar calendar);

    Discount date(Calendar calendar, Order order);

    Discount specialDay(Calendar calendar);
}
