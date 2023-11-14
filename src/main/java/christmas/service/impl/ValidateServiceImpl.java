package christmas.service.impl;

import static christmas.constants.CharConstants.COMMAS;
import static christmas.constants.DayConstants.FIRST_DAY;
import static christmas.constants.DayConstants.LAST_DAY;

import christmas.service.ValidateService;
import java.util.List;

public class ValidateServiceImpl implements ValidateService {
    private long countChar(String str) {
        return str.chars().filter(c -> c == COMMAS.getValue()).count();
    }

    @Override
    public void date(Integer date) {
        if (isStart(date) || isEnd(date)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void commas(List<String> orders, String input) {
        int orderSize = orders.size();
        long commasCount = countChar(input);
        if (orderSize - 1 != commasCount) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void checkOnlyBeverage(Integer count, int menus) {
        if (count.equals(menus)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEnd(Integer date) {

        return date > LAST_DAY.getDay();
    }

    private boolean isStart(Integer date) {
        return date < FIRST_DAY.getDay();
    }
}
