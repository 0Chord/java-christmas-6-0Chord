package christmas.vo;

import static christmas.constants.DiscountConstants.GIVEAWAY_EVENT;
import static christmas.constants.DiscountConstants.NOTHING;

import christmas.constants.NumberConstants;

public class Giveaway {

    private final int menu;

    public Giveaway(long money) {
        int menu;
        menu = NumberConstants.NOTHING.getValue();
        if (isMoneyBiggerThanAppropriateAmount(money)) {
            menu = NumberConstants.ONE.getValue();
        }
        this.menu = menu;

    }

    private boolean isMoneyBiggerThanAppropriateAmount(Long money) {
        return money >= NumberConstants.GIVEAWAY_EVENT_MINIMUM_PRICE.getValue();
    }

    public long getPrice() {
        if (menu == NumberConstants.ONE.getValue()) {
            return GIVEAWAY_EVENT.getValue();
        }
        return NOTHING.getValue();
    }
}
