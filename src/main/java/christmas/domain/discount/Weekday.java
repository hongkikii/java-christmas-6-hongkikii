package christmas.domain.discount;

import static christmas.domain.Menu.Type.*;

import christmas.domain.Menu;
import christmas.domain.Menu.Type;
import christmas.domain.Order;
import christmas.domain.discount.Discount;
import java.util.Map.Entry;

public class Weekday extends Discount {

    public Weekday(String name) {
        super(name);
    }

    @Override
    public void calculate(int date, Order order) {
        int countDesert = 0;
        if (isWeekday(date)) {
            for (Entry<Menu, Integer> element : order.getEntrySet()) {
                Menu menu = element.getKey();
                if(menu.getType() == DESERT) {
                    countDesert += element.getValue();
                }
            }
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
