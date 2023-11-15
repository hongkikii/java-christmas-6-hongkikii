package christmas.domain.discount;

import static christmas.constant.Constants.Gift.*;
import static christmas.domain.Menu.*;

import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.Map;

public class Gift extends Discount {
    private final Map<Menu, Integer> giftMenu;

    public Gift() {
        super(GIFT_DISCOUNT_NAME);
        this.giftMenu = new HashMap<>();
    }

    public Map<Menu, Integer> get() {
        return this.giftMenu;
    }

    public Integer getPrice() {
        return giftMenu.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public void calculate(int date, Order order) {
        if (order.getTotalPrice() > MIN_GIFT_PRICE) {
            add();
        }
    }

    private void add() {
        giftMenu.put(CHAMPAGNE, GIFT_CHAMPAGNE_COUNT);
        giftMenu.forEach((menu, count) -> save(menu.getPrice() * count));
    }
}
