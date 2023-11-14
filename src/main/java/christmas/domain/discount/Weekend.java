package christmas.domain.discount;

import static christmas.constant.Constants.Weekend.*;
import static christmas.domain.DayInformation.WeekType.*;

import christmas.domain.Order;

public class Weekend extends Discount {

    public Weekend() {
        super(WEEKEND_DISCOUNT_NAME);
    }

    @Override
    public void calculate(int date, Order order) {
        if (isWeekType(date, WEEKEND)) {
            int countMain = order.countMain();
            save(WEEKEND_BASE_DISCOUNT * countMain);
        }
    }
}
