package christmas.domain.discount;

import static christmas.constant.Constants.Common.*;
import static christmas.domain.DayInformation.getDayInformation;

import christmas.domain.DayInformation;
import christmas.domain.DayInformation.WeekType;
import christmas.domain.Order;

public abstract class Discount {
    private String name;
    private Integer price;

    public Discount(String name) {
        this.name = name;
        this.price = ZERO;
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

    protected Boolean isWeekType(int date, WeekType weekType) {
        DayInformation dayInformation = getDayInformation(date);
        if (dayInformation.getWeekType() == weekType) {
            return true;
        }
        return false;
    }
}
