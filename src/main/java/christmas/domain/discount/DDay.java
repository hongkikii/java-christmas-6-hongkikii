package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.discount.Discount;

public class DDay extends Discount {

    public DDay(String name) {
        super(name);
    }

    @Override
    public void calculate(int date, Order order) {
        if (date < 25) {
            save( 1000 + ((date-1) *100));
        }
    }
}
