package christmas.domain;

import static christmas.constants.NumberConstants.MAX_ORDER_COUNT;
import static christmas.constants.TypeConstants.UNIT_OF_ORDERS;

import christmas.vo.OrderQuantity;
import java.util.List;

public class Order {
    private final List<OrderQuantity> orders;

    public Order(List<OrderQuantity> orders) {
        isSizeBiggerThanTwenty(orders);
        this.orders = orders;
    }

    private void isSizeBiggerThanTwenty(List<OrderQuantity> orders) {
        long menuCount = orders.stream()
                .mapToLong(OrderQuantity::getQuantity)
                .sum();

        if (menuCount > MAX_ORDER_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getOrderStatus() {
        return orders.stream()
                .map(order -> String.format(UNIT_OF_ORDERS.getName(), order.getName(), order.getQuantity()))
                .toList();
    }

    public Long getTotalOrderAmount() {
        return orders.stream()
                .mapToLong(order -> order.getPrice() * order.getQuantity())
                .sum();
    }

    public Long getCountQuantityFromCategory(String category) {
        return orders.stream()
                .mapToLong(order -> order.getQuantityFromCategory(category))
                .sum();
    }
}
