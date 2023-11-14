package christmas.domain;

import christmas.message.SystemMessage;
import christmas.service.impl.ConvertServiceImpl;
import christmas.vo.Discount;
import christmas.vo.Giveaway;
import java.util.ArrayList;
import java.util.List;

public class Benefit {
    private List<Discount> discounts;
    private Giveaway giveaway;

    public Benefit(List<Discount> discounts, Giveaway giveaway) {
        this.discounts = discounts;
        this.giveaway = giveaway;
    }

    public Long calcTotalBenefitAmount() {
        long totalBenefitAmount = calcDiscountAmount();
        totalBenefitAmount += giveaway.getPrice();
        return -totalBenefitAmount;
    }

    public Long calcDiscountAmount() {
        return discounts.stream()
                .mapToLong(Discount::getAmount)
                .sum();
    }

    public List<String> benefitDetails() {
        ConvertServiceImpl convertService = new ConvertServiceImpl();
        List<String> details = new ArrayList<>();
        for (Discount discount : discounts) {
            if (discount.isCategory("weekday")) {
                details.add(SystemMessage.WEEKDAY_DISCOUNT.getMessage() + convertService.longToString(
                        -discount.getAmount()));
            }
            if (discount.isCategory("weekend")) {
                details.add(SystemMessage.WEEKEND_DISCOUNT.getMessage() + convertService.longToString(
                        -discount.getAmount()));
            }
            if (discount.isCategory("special")) {
                details.add(SystemMessage.SPECIAL_DISCOUNT.getMessage() + convertService.longToString(
                        -discount.getAmount()));
            }
            if (discount.isCategory("christmas")) {
                details.add(SystemMessage.D_DAY_DISCOUNT.getMessage() + convertService.longToString(
                        -discount.getAmount()));
            }
        }
        if (discounts.size() == 0) {
            details.add("없음");
            return details;
        }
        details.add(SystemMessage.EVENT.getMessage() + convertService.longToString(-giveaway.getPrice()));
        return details;
    }

    public String badge() {
        long totalBenefitAmount = -calcTotalBenefitAmount();
        if (totalBenefitAmount >= 20000) {
            return "산타";
        } else if (totalBenefitAmount >= 10000) {
            return "트리";
        } else if (totalBenefitAmount >= 5000) {
            return "별";
        }

        return "없음";
    }
}
