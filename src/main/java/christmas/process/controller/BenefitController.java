package christmas.process.controller;

import static christmas.constants.NumberConstants.MINIMUM_DISCOUNT_ORDER_PRICE;

import christmas.constants.NumberConstants;
import christmas.domain.Benefit;
import christmas.domain.Calendar;
import christmas.domain.Order;
import christmas.service.DiscountService;
import christmas.vo.Discount;
import christmas.vo.Giveaway;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BenefitController {
    private final DiscountService discountService;

    public BenefitController(DiscountService discountService) {
        this.discountService = discountService;
    }

    public Benefit make(Calendar calendar, Order order, Long totalAmount) {
        List<Discount> discounts;

        discounts = Collections.emptyList();

        if (totalAmount >= MINIMUM_DISCOUNT_ORDER_PRICE.getValue()) {
            discounts = Arrays.asList(
                    discountService.date(calendar, order),
                    discountService.christmas(calendar),
                    discountService.specialDay(calendar)
            );
        }

        Giveaway giveaway = new Giveaway(totalAmount);
        return new Benefit(discounts, giveaway);
    }
}
