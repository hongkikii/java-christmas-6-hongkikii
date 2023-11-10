package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private int date;
    private String order;

    public InputView() {
        this.date = 0;
        this.order = "";
    }

    public int getDate() {
        return date;
    }

    public String getOrder() {
        return order;
    }

    public void introduce() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while (true) {
            String input = Console.readLine();
            try {
                this.date = validateDate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateDate(String input) {
        int date = checkNumber(input);
        checkBoundary(date);
        return date;
    }

    private int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private int checkBoundary(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return date;
    }

    public void readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while (true) {
            String input = Console.readLine();
            try {
                validateOrder(input);
                this.order = input;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateOrder(String order) {
        checkForm(order);
        String[] orders = order.split(",");
        checkNoMenu(orders);
        checkCount(orders); // 1이상, 전체 20이하
        checkDuplicateMenu(orders);
    }

    private void checkForm(String order) {
        String regex = "^[가-힣]+-\\d+(,[가-힣]+-\\d+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(order);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.1");
        }
    }

    private void checkNoMenu(String[] orders) {
        for (String order : orders) {
            String name = order.split("-")[0];
            if (contain(name)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.2");
    }

    private boolean contain(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void checkCount(String[] orders) {
        for (String order : orders) {
            String count = order.split("-")[1];
            int number = Integer.parseInt(count);
            if (number < 1 || number > 20) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.3");
            }
        }
    }

    private void checkDuplicateMenu(String[] orders) {
        HashSet<String> noDuplicateMenu = new HashSet<>();
        for (String order : orders) {
            String name = order.split("-")[0];
            noDuplicateMenu.add(name);
        }
        if (noDuplicateMenu.size() != orders.length) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.4");
        }
    }
}
