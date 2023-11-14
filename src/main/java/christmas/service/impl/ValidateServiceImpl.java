package christmas.service.impl;

import christmas.service.ValidateService;
import java.util.List;

public class ValidateServiceImpl implements ValidateService {
    private long countChar(String str) {
        return str.chars().filter(c -> c == ',').count();
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

    private boolean isEnd(Integer date) {
        return date > 31;
    }

    private boolean isStart(Integer date) {
        return date < 1;
    }
}
