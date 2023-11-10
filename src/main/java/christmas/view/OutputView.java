package christmas.view;

import christmas.domain.Badge;
import christmas.domain.discount.Discount;
import christmas.domain.Menu;
import christmas.domain.Order;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printHeader(int date) {
        System.out.println("12월 " + date + "일에 우테고 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printMenu(Order order) {
        System.out.println("<주문 메뉴>");
        Map<Menu, Integer> orders = order.get();
        for (Map.Entry<Menu, Integer> entry : orders.entrySet()) {
            Menu menu = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(menu.getName() + " " + quantity + "개");
        }
        System.out.println();
    }

    private void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formattedPrice = decimalFormat.format(totalPrice);
        System.out.println(formattedPrice +"원");
        System.out.println();
    }

    private void printGiftMenu(boolean isPresented) {
        System.out.println("<증정 메뉴>");
        if (isPresented) {
            System.out.println("샴페인 1개");
        }
        if (!isPresented) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printBenefitList(List<Discount> discounts) {
        System.out.println("<혜택 내역>");
        for (Discount discount : discounts) {
            System.out.print(discount.getName() + ": ");
            System.out.println("-" + discount.getPrice() + "원");
        }
        if (discounts.size() == 0) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printBenefitPrice(int benefitPrice) {
        System.out.println("<총혜택 금액>");
        if (benefitPrice == 0) {
            System.out.println("0원");
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formattedPrice = decimalFormat.format(benefitPrice);
        System.out.println("-" + formattedPrice + "원");
        System.out.println();
    }

    private void printAmountOfPayment(int amountOfPayment) {
        System.out.println("<할인 후 예상 결제 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formattedPrice = decimalFormat.format(amountOfPayment);
        System.out.println(formattedPrice + "원");
        System.out.println();
    }

    private void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        if (badge == null) {
            System.out.println("없음");
            return;
        }
        System.out.println(badge.getName());
    }

}
