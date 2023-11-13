package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.discount.Discount;

public class Special extends Discount {

    public Special() {
        super("특별 할인");
    }

    @Override
    public void calculate(int date, Order order) {
        if (isSpecial(date)) {
            save(1000);
        }
    }

    private boolean isSpecial(int date) {
        if (date == 3 || date == 10 || date == 17 || date == 24 || date == 31) {
            return true;
        }
        if (date == 25) {
            return true;
        }
        return false;
    }
}
