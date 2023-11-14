package christmas.process.controller;

import christmas.domain.Order;

public class TotalAmountController {
    public Long totalAmount(Order order) {
        return order.getTotalOrderAmount();
    }
}
