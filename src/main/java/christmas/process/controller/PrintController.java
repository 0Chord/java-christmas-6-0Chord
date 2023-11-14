package christmas.process.controller;

import christmas.domain.Benefit;
import christmas.domain.Calendar;
import christmas.domain.Order;
import christmas.ioadapter.OutputAdapter;
import christmas.message.SystemMessage;
import christmas.service.ConvertService;
import java.util.List;

public class PrintController {

    private final OutputAdapter outputAdapter;
    private final ConvertService convertService;

    public PrintController(OutputAdapter outputAdapter, ConvertService convertService) {
        this.outputAdapter = outputAdapter;
        this.convertService = convertService;
    }

    public void totalBenefit(Benefit benefit) {
        SystemMessage totalBenefitAmount = SystemMessage.TOTAL_BENEFIT_AMOUNT;
        outputAdapter.printMessage(totalBenefitAmount.getMessage());
        Long benefitAmount = benefit.calcTotalBenefitAmount();
        String benefitConvert = convertService.longToString(benefitAmount);
        outputAdapter.printMessage(benefitConvert);
        outputAdapter.printNewline();
    }

    public void mainStart() {
        outputAdapter.printMessage(SystemMessage.START.getMessage());
        outputAdapter.printMessage(SystemMessage.DATE.getMessage());
    }

    public void select() {
        outputAdapter.printMessage(SystemMessage.SELECT.getMessage());
    }

    public void introduction(Calendar calendar) {
        SystemMessage introduction = SystemMessage.INTRODUCTION;
        outputAdapter.printMessage(introduction.event(calendar.getDay()));
    }

    public void order(Order order) {
        outputAdapter.printNewline();
        outputAdapter.printMessage(SystemMessage.ORDER_MENU.getMessage());
        order.getOrderStatus().forEach(outputAdapter::printMessage);
        outputAdapter.printNewline();
    }

    public void totalOrderAmount() {
        SystemMessage totalOrderAmount = SystemMessage.TOTAL_ORDER_AMOUNT;
        outputAdapter.printMessage(totalOrderAmount.getMessage());
    }

    public void totalAmount(Long totalAmount) {
        String longToString = convertService.longToString(totalAmount);
        outputAdapter.printMessage(longToString);
        outputAdapter.printNewline();
    }

    public void giveaway(Long totalAmount) {
        SystemMessage giveawayMenu = SystemMessage.GIVEAWAY_MENU;
        outputAdapter.printMessage(giveawayMenu.getMessage());
        outputAdapter.printMessage(giveawayMenu.menu(totalAmount));
        outputAdapter.printNewline();
    }

    public void benefitDetails() {
        SystemMessage benefitDetails = SystemMessage.BENEFIT_DETAILS;
        outputAdapter.printMessage(benefitDetails.getMessage());
    }

    public void details(Benefit benefit) {
        List<String> details = benefit.benefitDetails();
        details.forEach(outputAdapter::printMessage);
        outputAdapter.printNewline();
    }

    public void discountAmount(Benefit benefit, Long totalAmount) {
        SystemMessage expectedPaymentAmount = SystemMessage.EXPECTED_PAYMENT_AMOUNT;
        outputAdapter.printMessage(expectedPaymentAmount.getMessage());
        Long discountAmount = benefit.calcDiscountAmount();
        long amountAfterDiscount = totalAmount - discountAmount;
        String amount = convertService.longToString(amountAfterDiscount);
        outputAdapter.printMessage(amount);
        outputAdapter.printNewline();
    }

    public void badge(Benefit benefit) {
        SystemMessage badge = SystemMessage.BADGE;
        outputAdapter.printMessage(badge.getMessage());
        String getBadge = benefit.badge();
        outputAdapter.printMessage(getBadge);
    }
}
