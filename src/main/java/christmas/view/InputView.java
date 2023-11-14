package christmas.view;

import static christmas.constant.Constants.Common.*;
import static christmas.constant.Constants.InputView.*;
import static christmas.constant.Constants.Error.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private int date;
    private Order order;

    public InputView() {
        this.date = ZERO;
        this.order = new Order();
    }

    public void run() {
        introduce();
        readDate();
        readOrder();
    }

    public int getDate() {
        return date;
    }

    public Order getOrder() {
        return order;
    }

    private void introduce() {
        System.out.println(INTRODUCE);
    }

    private void readDate() {
        System.out.println(ASK_DATE);
        read(DATE);
    }

    private void readOrder() {
        System.out.println(ASK_ORDER);
        read(ORDER);
    }

    private String read(String type) {
        String input;
        while (true) {
            input = Console.readLine();
            try {
                validateInput(type, input);
                saveInput(type, input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    private void validateInput(String type, String input) {
        if (type.equals(DATE)) {
            validateDate(input);
        }
        if (type.equals(ORDER)) {
            validateOrder(input);
        }
    }

    private void saveInput(String type, String input) {
        if (type.equals(DATE)) {
            date = Integer.parseInt(input);
        }
        if (type.equals(ORDER)) {
            order.save(input);
        }
    }

    private void validateDate(String input) {
        int date = checkNumber(input);
        checkBoundary(date);
    }

    private void validateOrder(String orderLine) {
        checkForm(orderLine);
        List<String> orders = Arrays.asList(orderLine.split(ORDER_SPLIT));
        checkNoMenu(orders);
        checkCount(orders);
        checkDuplicateMenu(orders);
    }

    private int checkNumber(String date) {
        try {
            return Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_DATE);
        }
    }

    private int checkBoundary(int date) {
        if (date < DECEMBER_START || date > DECEMBER_END) {
            throw new IllegalArgumentException(ERROR_DATE);
        }
        return date;
    }

    private void checkForm(String orderLine) {
        String regex = ORDER_REGEX;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(orderLine);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_ORDER);
        }
    }

    private void checkNoMenu(List<String> orders) {
        if (orders.stream()
                .map(order -> order.split(MENU_AND_COUNT_SPLIT)[MENU_NAME_INDEX])
                .allMatch(this::contain)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_ORDER);
    }

    private boolean contain(String menuName) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.getName().equals(menuName));
    }

    private void checkCount(List<String> orders) {
        if (orders.stream()
                .map(order -> Integer.parseInt(order.split(MENU_AND_COUNT_SPLIT)[MENU_COUNT_INDEX]))
                .allMatch(count -> count >= MIN_ORDER_COUNT && count <= MAX_ORDER_COUNT)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_ORDER);
    }

    private void checkDuplicateMenu(List<String> orders) {
        List<String> noDuplicateMenu = orders.stream()
                .map(order -> order.split(MENU_AND_COUNT_SPLIT)[MENU_NAME_INDEX])
                .distinct()
                .collect(Collectors.toList());

        if (noDuplicateMenu.size() != orders.size()) {
            throw new IllegalArgumentException(ERROR_ORDER);
        }
    }
}
