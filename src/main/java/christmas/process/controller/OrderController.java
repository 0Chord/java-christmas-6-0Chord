package christmas.process.controller;

import static christmas.constants.TypeConstants.APPETIZER;
import static christmas.constants.TypeConstants.BEVERAGE;
import static christmas.constants.TypeConstants.DASH;
import static christmas.constants.TypeConstants.DESSERT;
import static christmas.constants.TypeConstants.MAIN;

import christmas.domain.Food;
import christmas.domain.Order;
import christmas.ioadapter.InputAdapter;
import christmas.ioadapter.OutputAdapter;
import christmas.message.ErrorMessage;
import christmas.service.ConvertService;
import christmas.service.ValidateService;
import christmas.vo.MenuState;
import christmas.vo.OrderQuantity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderController {

    private final InputAdapter inputAdapter;
    private final ConvertService convertService;
    private final ValidateService validateService;
    private final OutputAdapter outputAdapter;

    public OrderController(InputAdapter inputAdapter, ConvertService convertService, ValidateService validateService,
                           OutputAdapter outputAdapter) {
        this.inputAdapter = inputAdapter;
        this.convertService = convertService;
        this.validateService = validateService;
        this.outputAdapter = outputAdapter;
    }

    public Order make(Food food) {
        while (true) {
            try {
                List<String> orders = getOrders();
                List<OrderQuantity> orderQuantities = getOrderQuantities(food, orders);
                return new Order(orderQuantities);
            } catch (IllegalArgumentException exception) {
                ErrorMessage orderError = ErrorMessage.ORDER;
                outputAdapter.printMessage(orderError.getMessage());
            }
        }
    }

    private List<OrderQuantity> getOrderQuantities(Food food, List<String> orders) {
        List<OrderQuantity> orderQuantities = new ArrayList<>();
        List<String> menus = new ArrayList<>();
        processOrder(food, orders, orderQuantities, menus);
        int beverageCount = (int) menus.stream()
                .filter(menu -> food.isMatch(BEVERAGE.getName(), menu))
                .count();
        validateService.checkOnlyBeverage(beverageCount, menus.size());
        return orderQuantities;
    }

    private void processOrder(Food food, List<String> orders, List<OrderQuantity> orderQuantities, List<String> menus) {
        List<String> CATEGORIES = Arrays.asList(APPETIZER.getName(), BEVERAGE.getName(), DESSERT.getName(),
                MAIN.getName());
        for (String orderStatus : orders) {
            MenuState menu = new MenuState(Arrays.asList(orderStatus.split(DASH.getName())));
            isSameMenu(menus, menu);
            String category = CATEGORIES.stream()
                    .filter(c -> food.isMatch(c, menu.name()))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
            Integer price = food.getPrice(category, menu.name());
            OrderQuantity orderQuantity = new OrderQuantity(category, menu.quantity(), menu.name(), price);
            orderQuantities.add(orderQuantity);
            menus.add(menu.name());
        }
    }

    private List<String> getOrders() {
        String orderInput = inputAdapter.inputStream();
        List<String> orders = convertService.stringToList(orderInput);
        validateService.commas(orders, orderInput);
        return orders;
    }

    private void isSameMenu(List<String> menus, MenuState menu) {
        if (menus.size() > 0 && menus.get(0).equals(menu.name())) {
            throw new IllegalArgumentException();
        }
    }
}
