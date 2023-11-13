package christmas.domain.discount;

import christmas.domain.Order;

public class DDay extends Discount {

    public DDay() {
        super("크리스마스 디데이 할인");
    }

    @Override
    public void calculate(int date, Order order) {
        if (date <= 25) {
            save( 1000 + ((date-1) *100));
        }
    }
}
