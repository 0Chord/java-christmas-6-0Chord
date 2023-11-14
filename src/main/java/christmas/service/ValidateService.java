package christmas.service;

import java.util.List;

public interface ValidateService {
    void date(Integer date);

    void commas(List<String> orders, String input);

    void checkOnlyBeverage(Integer count, int menus);
}
