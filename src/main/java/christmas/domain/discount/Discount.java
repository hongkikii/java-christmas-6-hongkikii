package christmas.domain.discount;

import christmas.domain.Order;

public abstract class Discount {
    private String name;
    private Integer price;

    public Discount(String name) {
        this.name = name;
        this.price = 0;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void save(int price) {
        this.price = price;
    }

    public abstract void calculate(int date, Order order);

}
