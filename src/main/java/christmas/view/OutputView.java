package christmas.view;

import christmas.domain.Badge;
import christmas.domain.discount.Discount;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.discount.Discounts;
import christmas.domain.discount.Gift;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printHeader(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void printResult(Order order, Discounts discounts) {
        printMenu(order);
        printTotalPrice(order.getTotalPrice());
        printGiftMenu(discounts.findGift());
        printBenefitList(discounts.get());
        printBenefitPrice(discounts.getBenefitPrice());
        printAmountOfPayment(discounts.getAmountOfPayment(order));
        printBadge(discounts.getBadge());
    }

    private void printMenu(Order order) {
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

    private void printGiftMenu(Gift gift) {
        System.out.println("<증정 메뉴>");
        Map<Menu, Integer> giftMenu = gift.getMenu();
        for (Map.Entry<Menu, Integer> entry : giftMenu.entrySet()) {
            Menu menu = entry.getKey();
            Integer number = entry.getValue();
            System.out.println(menu.getName() + " " + number + "개");
        }
        if (giftMenu.size() == 0) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printBenefitList(List<Discount> discounts) {
        System.out.println("<혜택 내역>");
        int totalDiscountPrice = 0;
        for (Discount discount : discounts) {
            Integer discountPrice = discount.getPrice();
            if(discountPrice != 0) {
                System.out.print(discount.getName() + ": ");
                DecimalFormat decimalFormat = new DecimalFormat("###,###");
                String formattedPrice = decimalFormat.format(discount.getPrice());
                System.out.println("-" + formattedPrice + "원");
                totalDiscountPrice += discountPrice;
            }
        }
        if (totalDiscountPrice == 0) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printBenefitPrice(int benefitPrice) {
        System.out.println("<총혜택 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formattedPrice = decimalFormat.format(benefitPrice);
        if (!formattedPrice.equals("0")) {
            formattedPrice = "-" + formattedPrice;
        }
        System.out.println(formattedPrice + "원");
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
        System.out.println(badge.getName());
    }
}
