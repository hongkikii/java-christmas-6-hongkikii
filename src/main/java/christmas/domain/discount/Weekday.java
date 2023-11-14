package christmas.domain.discount;

import static christmas.constant.Constants.Weekday.*;
import static christmas.domain.DayInformation.WeekType.*;

import christmas.domain.Order;

public class Weekday extends Discount {

    public Weekday() {
        super(WEEKDAY_DISCOUNT_NAME);
    }

    @Override
    public void calculate(int date, Order order) {
        if (isWeekType(date, WEEKDAY)) {
            int countDesert = order.countDesert();
            save(WEEKDAY_BASE_DISCOUNT * countDesert);
        }
    }
}
