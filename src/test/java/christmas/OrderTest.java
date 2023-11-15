package christmas;

import christmas.config.ApplicationConfig;
import christmas.domain.Food;
import christmas.domain.Order;
import christmas.process.controller.FoodController;
import christmas.process.controller.OrderController;
import christmas.service.ConvertService;
import christmas.service.ValidateService;
import christmas.vo.OrderQuantity;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {

    @DisplayName("콤마를 잘못 입력하면 오류")
    @ValueSource(strings = {"타파스-1,제로콜라-1,", "타파스-1,,제로콜라-1", ",타파스-1,제로콜라-1"})
    @ParameterizedTest
    void order(String input) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        ConvertService convertService = applicationConfig.convertService();
        List<String> orders = convertService.stringToList(input);
        ValidateService validateService = applicationConfig.validateService();
        Assertions.assertThatThrownBy(() -> validateService.commas(orders, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 잘못 입력 시 오류 발생")
    @ValueSource(strings = {"레드와인-1,제로콜라-1", "레드와인-1,레드와인-2", "타파스-2,제로콜라-1,타파스-1","타파스-2,제로콜라-a","타파스=2,제로콜라-1"})
    @ParameterizedTest
    void wrongOrder(String input) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        ConvertService convertService = applicationConfig.convertService();
        ValidateService validateService = applicationConfig.validateService();
        List<String> orders = convertService.stringToList(input);
        validateService.commas(orders, input);
        FoodController foodController = applicationConfig.foodController();
        OrderController orderController = applicationConfig.orderController();
        Food food = foodController.make();

        Assertions.assertThatThrownBy(() -> orderController.getOrderQuantities(food, orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수량 20개가 초과 시 오류 발생")
    @ValueSource(strings = {"타파스-20,제로콜라-1"})
    @ParameterizedTest
    void orderSize(String input) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        ConvertService convertService = applicationConfig.convertService();
        ValidateService validateService = applicationConfig.validateService();
        List<String> orders = convertService.stringToList(input);
        validateService.commas(orders, input);
        FoodController foodController = applicationConfig.foodController();
        OrderController orderController = applicationConfig.orderController();
        Food food = foodController.make();
        List<OrderQuantity> orderQuantities = orderController.getOrderQuantities(food, orders);
        Assertions.assertThatThrownBy(() -> new Order(orderQuantities))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
