package christmas.domain;

public abstract class Discount {
    private String name;
    private Integer price;

    public Discount(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public abstract void calculate();
}
