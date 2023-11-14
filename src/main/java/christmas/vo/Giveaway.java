package christmas.vo;

public class Giveaway {

    private final int menu;

    public Giveaway(long money) {
        int menu;
        menu = 0;
        if (isMoneyBiggerThanAppropriateAmount(money)) {
            menu = 1;
        }
        this.menu = menu;

    }

    private boolean isMoneyBiggerThanAppropriateAmount(Long money) {
        return money >= 120000;
    }

    public long getPrice() {
        if (menu == 1) {
            return 25000L;
        }
        return 0L;
    }
}
