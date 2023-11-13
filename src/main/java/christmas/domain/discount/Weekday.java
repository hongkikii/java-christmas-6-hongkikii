package christmas.domain.discount;

import christmas.domain.Order;

public class Weekday extends Discount {

    public Weekday() {
        super("평일 할인");
    }

    @Override
    public void calculate(int date, Order order) {
        if (isWeekday(date)) {
            int countDesert = order.countDesert();
            save(2023 * countDesert);
        }
    }

    private boolean isWeekday(int date) {
        if ((date >= 3 && date <= 7) || (date >= 10 && date <= 14)) {
            return true;
        }
        if ((date >= 17 && date <= 21) || (date >= 24 && date <= 28)) {
            return true;
        }
        if (date == 31) {
            return true;
        }
        return false;
    }
}
