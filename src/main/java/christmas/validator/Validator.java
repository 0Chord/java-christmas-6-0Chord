package christmas.validator;

public class Validator {
    public void checkOnlyBeverage(Integer count, int menus) {
        if (count.equals(menus)) {
            throw new IllegalArgumentException();
        }
    }
}
