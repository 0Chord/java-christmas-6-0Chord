package christmas.vo;

public final class OrderQuantity{

    private final String category;
    private final Long quantity;
    private final String name;
    private final Integer price;

    public OrderQuantity(String category, Long quantity, String name, Integer price) {
        this.category = category;
        isNaturalNumber(quantity);
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    private void isNaturalNumber(Long quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Long getQuantityFromCategory(String category) {
        if (category.equals(this.category)) {
            return quantity;
        }
        return 0L;
    }
}
