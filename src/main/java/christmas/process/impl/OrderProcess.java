package christmas.process.impl;

import christmas.domain.Benefit;
import christmas.domain.Calendar;
import christmas.domain.Food;
import christmas.domain.Order;
import christmas.process.Process;
import christmas.process.controller.BenefitController;
import christmas.process.controller.CalendarController;
import christmas.process.controller.FoodController;
import christmas.process.controller.OrderController;
import christmas.process.controller.PrintController;
import christmas.process.controller.TotalAmountController;

public class OrderProcess implements Process {

    private final PrintController printController;
    private final OrderController orderController;
    private final FoodController foodController;
    private final CalendarController calendarController;
    private final TotalAmountController totalAmountController;
    private final BenefitController benefitController;

    public OrderProcess(PrintController printController, OrderController orderController, FoodController foodController,
                        CalendarController calendarController, TotalAmountController totalAmountController,
                        BenefitController benefitController) {
        this.printController = printController;
        this.orderController = orderController;
        this.foodController = foodController;
        this.calendarController = calendarController;
        this.totalAmountController = totalAmountController;
        this.benefitController = benefitController;
    }

    @Override
    public void play() {
        Food food = foodController.make();
        Calendar calendar = makeCalendar();
        printController.select();
        Order order = makeOrder(food, calendar);
        printController.totalOrderAmount();
        Long totalAmount = totalAmountController.totalAmount(order);
        printDiscount(totalAmount);
        Benefit benefit = benefitController.make(calendar, order, totalAmount);
        printDetails(totalAmount, benefit);
    }

    private Order makeOrder(Food food, Calendar calendar) {
        Order order = orderController.make(food);
        printController.introduction(calendar);
        printController.order(order);
        return order;
    }

    private Calendar makeCalendar() {
        printController.mainStart();
        return calendarController.make();
    }

    private void printDiscount(Long totalAmount) {
        printController.totalAmount(totalAmount);
        printController.giveaway(totalAmount);
        printController.benefitDetails();
    }

    private void printDetails(Long totalAmount, Benefit benefit) {
        printController.details(benefit);
        printController.totalBenefit(benefit);
        printController.discountAmount(benefit, totalAmount);
        printController.badge(benefit);
    }
}
