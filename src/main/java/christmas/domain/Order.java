package christmas.domain;

import static christmas.domain.Menu.Type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Order {
    private final Map<Menu, Integer> order;
    private boolean eventApply;

    public Order() {
        this.order = new HashMap<>();
        this.eventApply = false;
    }

    public Map<Menu, Integer> get() {
        return this.order;
    }

    public Boolean getEventApply() {
        return this.eventApply;
    }

    public Set<Entry<Menu, Integer>> getEntrySet() {
        return this.order.entrySet();
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
        // 총주문 금액 10000원 이상
        if (getTotalPrice() >= 10000) {
            this.eventApply = true;
        }
        // 음료만 주문 X
        int notDrink = 0;
        for(Entry<Menu, Integer> entry : this.order.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType() != DRINK) {
                notDrink++;
            }
        }
        if (notDrink == 0) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문은 앙 대 여 !");
        }
        // 주문 20개 이상
        int totalOrder = 0;
        for(Entry<Menu, Integer> entry : this.order.entrySet()) {
            totalOrder += entry.getValue();
        }
        if (totalOrder > 20) {
            throw new IllegalArgumentException("[ERROR] 주문 20개 이상 안됨요");
        }
    }

    public Integer getTotalPrice() {
        int result = 0;
        for (Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            Integer number = entry.getValue();
            int price = menu.getPrice();
            result += (price * number);
        }
        return result;
    }

    public int countMain() {
        int count = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            if (menu.getType() == MAIN) {
                count++;
            }
        }
        return count;
    }
}
