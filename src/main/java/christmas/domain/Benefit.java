package christmas.domain;

import static christmas.constants.TypeConstants.CHRISTMAS;
import static christmas.constants.TypeConstants.NOTHING;
import static christmas.constants.TypeConstants.SANTA;
import static christmas.constants.TypeConstants.SPECIAL_DAY;
import static christmas.constants.TypeConstants.STAR;
import static christmas.constants.TypeConstants.TREE;
import static christmas.constants.TypeConstants.WEEKDAY;
import static christmas.constants.TypeConstants.WEEKEND;

import christmas.constants.NumberConstants;
import christmas.message.SystemMessage;
import christmas.service.ConvertService;
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
            applyDiscount(details, discount, WEEKDAY.getName(), SystemMessage.WEEKDAY_DISCOUNT, convertService);
            applyDiscount(details, discount, WEEKEND.getName(), SystemMessage.WEEKEND_DISCOUNT, convertService);
            applyDiscount(details, discount, SPECIAL_DAY.getName(), SystemMessage.SPECIAL_DISCOUNT, convertService);
            applyDiscount(details, discount, CHRISTMAS.getName(), SystemMessage.D_DAY_DISCOUNT, convertService);
        }
        if (discounts.size() == NumberConstants.NOTHING.getValue()) {
            details.add(NOTHING.getName());
            return details;
        }
        details.add(SystemMessage.EVENT.getMessage() + convertService.longToString(-giveaway.getPrice()));
        return details;
    }

    private void applyDiscount(List<String> details, Discount discount, String category, SystemMessage message,
                               ConvertService convertService) {

        if (discount.isCategory(category)) {
            details.add(message.getMessage() + convertService.longToString(-discount.getAmount()));
        }
    }

    public String badge() {
        long totalBenefitAmount = -calcTotalBenefitAmount();
        if (totalBenefitAmount >= NumberConstants.SANTA.getValue()) {
            return SANTA.getName();
        } else if (totalBenefitAmount >= NumberConstants.TREE.getValue()) {
            return TREE.getName();
        } else if (totalBenefitAmount >= NumberConstants.STAR.getValue()) {
            return STAR.getName();
        }

        return NOTHING.getName();
    }
}
