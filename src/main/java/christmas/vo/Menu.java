package christmas.vo;

public final class Menu {
    private final String menu;
    private final Integer price;

    public Menu(String menu, Integer price) {
        this.menu = menu;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public Integer getPrice() {
        return price;
    }
}
