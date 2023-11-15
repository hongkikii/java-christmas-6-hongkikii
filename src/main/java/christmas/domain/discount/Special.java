package christmas.domain.discount;

import static christmas.constant.Constants.Special.*;
import static christmas.domain.DayInformation.*;
import static christmas.domain.DayInformation.SpecialType.*;

import christmas.domain.Order;

public class Special extends Discount {

    public Special() {
        super(SPECIAL_DISCOUNT_NAME);
    }

    @Override
    public void calculate(int date, Order order) {
        if (isSpecial(date)) {
            save(SPECIAL_BASE_DISCOUNT);
        }
    }

    private boolean isSpecial(int date) {
        return getDayInformation(date).getSpecialType() == SPECIAL;
    }
}
