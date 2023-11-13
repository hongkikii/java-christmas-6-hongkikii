package christmas.domain.discount;

import christmas.domain.Order;

public class Weekend extends Discount {

    public Weekend() {
        super("주말 할인");
    }

    @Override
    public void calculate(int date, Order order) {
        if (isWeekend(date)) {
            int countMain = order.countMain();
            save(2023 * countMain);
        }
    }

    private boolean isWeekend(int date) {
        if (date == 1 || date == 2 || date == 8 || date == 9) {
            return true;
        }
        if (date == 15 || date == 16 || date == 22 || date == 23) {
            return true;
        }
        if (date == 29 || date == 30) {
            return true;
        }
        return false;
    }
}
