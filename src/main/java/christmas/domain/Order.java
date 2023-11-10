package christmas.domain;

import christmas.domain.Menu.Type;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> orders;

    public Order() {
        this.orders = new HashMap<>();
    }

    public Map<Menu, Integer> get() {
        return this.orders;
    }

    public Integer getTotalPrice() {
        int result = 0;
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            result += entry.getValue();
        }
        return result;
    }

    public int countDesert() {
        int count = 0;
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType() == Type.DESERT) {
                count++;
            }
        }
        return count;
    }

    public int countMain() {
        int count = 0;
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType() == Type.MAIN) {
                count++;
            }
        }
        return count;
    }
}
