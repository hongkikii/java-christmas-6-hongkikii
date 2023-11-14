package christmas.domain.discount;

import static christmas.constant.Constants.Weekday.*;
import static christmas.domain.DayInformation.*;
import static christmas.domain.DayInformation.WeekType.*;

import christmas.domain.DayInformation;
import christmas.domain.Order;

public class Weekday extends Discount {

    public Weekday() {
        super(WEEKDAY_DISCOUNT_NAME);
    }

    @Override
    public void calculate(int date, Order order) {
        if (isWeekday(date)) {
            int countDesert = order.countDesert();
            save(WEEKDAY_BASE_DISCOUNT * countDesert);
        }
    }

    private boolean isWeekday(int date) {
        DayInformation dayInformation = getDayInformation(date);
        if (dayInformation.getWeekType() == WEEKDAY) {
            return true;
        }
        return false;
    }
}
