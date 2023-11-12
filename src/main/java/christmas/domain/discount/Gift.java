package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.HashMap;
import java.util.Map;

public class Gift extends Discount {
    private Boolean isPresented;
    private Map<Menu, Integer> menu;

    public Gift(String name) {
        super(name);
        this.menu = new HashMap<>();
    }

    public Map<Menu, Integer> getMenu() {
        return this.menu;
    }

    @Override
    public void calculate(int date, Order order) {
        if (order.getTotalPrice() > 120000) {
            save(25000);
            addMenu();
        }
    }

    private void addMenu() {
        menu.put(Menu.CHAMPAGNE, 1);
    }
}
