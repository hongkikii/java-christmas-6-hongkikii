package christmas.domain.discount;

import static christmas.constant.Constants.DDay.*;

import christmas.domain.Order;

public class DDay extends Discount {

    public DDay() {
        super(DDAY_DISCOUNT_NAME);
    }

    @Override
    public void calculate(int date, Order order) {
        if (date <= DDAY) {
            save(BASE_DISCOUNT + ((date - 1) * ADD_DISCOUNT));
        }
    }
}
