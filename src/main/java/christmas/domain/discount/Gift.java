package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Gift extends Discount {
    private Map<Menu, Integer> giftMenu;

    public Gift() {
        super("증정 이벤트");
        this.giftMenu = new HashMap<>();
    }

    public Map<Menu, Integer> get() {
        return this.giftMenu;
    }

    public Integer getPrice() {
        int price = 0;
        for (Entry<Menu, Integer> element : giftMenu.entrySet()) {
            Menu menu = element.getKey();
            Integer count = element.getValue();
            price += (menu.getPrice() * count);
        }
        return price;
    }

    @Override
    public void calculate(int date, Order order) {
        if (order.getTotalPrice() > 120000) {
            save(25000);
            addMenu();
        }
    }

    private void addMenu() {
        giftMenu.put(Menu.CHAMPAGNE, 1);
    }
}
