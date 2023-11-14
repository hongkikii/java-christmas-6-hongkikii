package christmas.domain;

import static christmas.constant.Constants.Common.*;
import static christmas.constant.Constants.Error.*;
import static christmas.constant.Constants.Order.*;
import static christmas.domain.Menu.Type.*;

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

    public Boolean getEventApply() {
        return getTotalPrice() >= MIN_EVENT_APPLY_PRICE;
    }

    public void save(String orderLine) {
        String[] orders = orderLine.split(ORDER_SPLIT);
        for (String element : orders) {
            String[] menuAndNumber = element.split(MENU_AND_NUMBER_SPLIT);
            String orderMenu = menuAndNumber[0];
            String orderNumber = menuAndNumber[1];
            Menu menu = Menu.findMenu(orderMenu);
            int number = Integer.parseInt(orderNumber);
            order.put(menu, number);
        }
        validate();
    }

    public Integer getTotalPrice() {
        return order.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int countMain() {
        return countMenu(MAIN);
    }

    public int countDesert() {
        return countMenu(DESERT);
    }

    private void validate() {
        checkOrderOnlyDrink();
        checkMaxOrderCount();
    }

    private void checkOrderOnlyDrink() {
        if (order.entrySet().stream()
                .map(Map.Entry::getKey)
                .noneMatch(menu -> menu.getType() != DRINK)) {
            throw new IllegalArgumentException(ERROR_ORDER_ONLY_DRINK);
        }
    }

    private void checkMaxOrderCount() {
        int totalOrder = order.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (totalOrder > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException(ERROR_ORDER_EXCEED_MAX);
        }
    }

    private int countMenu(Type type) {
        return (int) order.entrySet().stream()
                .map(Map.Entry::getKey)
                .filter(menu -> menu.getType() == type)
                .count();
    }
}
