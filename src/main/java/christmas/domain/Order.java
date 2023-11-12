package christmas.domain;

import christmas.domain.Menu.Type;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> order;

    public Order() {
        this.order = new HashMap<>();
    }

    public Map<Menu, Integer> get() {
        return this.order;
    }

    public void save(String readLine) {
        String[] orders = readLine.split(",");
        for (String element : orders) {
            String[] menuAndNumber = element.split("-");
            String orderMenu = menuAndNumber[0];
            String orderNumber = menuAndNumber[1];
            Menu menu = Menu.findMenu(orderMenu);
            int number = Integer.parseInt(orderNumber);
            this.order.put(menu, number);
        }
    }


    public Integer getTotalPrice() {
        int result = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            Integer number = entry.getValue();
            int price = menu.getPrice();
            result += (price * number);
        }
        return result;
    }

    public int countDesert() {
        int count = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType() == Type.DESERT) {
                count++;
            }
        }
        return count;
    }

    public int countMain() {
        int count = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType() == Type.MAIN) {
                count++;
            }
        }
        return count;
    }
}
