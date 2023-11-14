package christmas.domain;

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

        if (menuCount > 20) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getOrderStatus() {
        return orders.stream()
                .map(order -> String.format("%s %s개", order.getName(), order.getQuantity()))
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
