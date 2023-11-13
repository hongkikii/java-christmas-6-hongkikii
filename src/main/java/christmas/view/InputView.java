package christmas.view;

import static christmas.constant.Constants.InputView.*;
import static christmas.constant.Constants.Error.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private int date;
    private Order order;

    public InputView() {
        this.date = 0;
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
        String input = read(DATE);
        date = Integer.parseInt(input);
    }

    private void readOrder() {
        System.out.println(ASK_ORDER);
        String input = read(ORDER);
        order.save(input);
    }

    private String read(String type) {
        String input;
        while (true) {
            input = Console.readLine();
            try {
                validateInput(type, input);
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

    private void validateDate(String input) {
        int date = checkNumber(input);
        checkBoundary(date);
    }

    private void validateOrder(String orderLine) {
        checkForm(orderLine);
        String[] orders = orderLine.split(ORDER_SPLIT);
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

    private void checkNoMenu(String[] orders) {
        for (String order : orders) {
            String menuName = order.split(MENU_AND_NUMBER_SPLIT)[0];
            if (contain(menuName)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_ORDER);
    }

    private boolean contain(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    private void checkCount(String[] orders) {
        for (String order : orders) {
            String count = order.split(MENU_AND_NUMBER_SPLIT)[1];
            int number = Integer.parseInt(count);
            if (number < MIN_ORDER_COUNT || number > MAX_ORDER_COUNT) {
                throw new IllegalArgumentException(ERROR_ORDER);
            }
        }
    }

    private void checkDuplicateMenu(String[] orders) {
        Set<String> noDuplicateMenu = new HashSet<>();
        for (String order : orders) {
            String name = order.split(MENU_AND_NUMBER_SPLIT)[0];
            noDuplicateMenu.add(name);
        }
        if (noDuplicateMenu.size() != orders.length) {
            throw new IllegalArgumentException(ERROR_ORDER);
        }
    }
}
