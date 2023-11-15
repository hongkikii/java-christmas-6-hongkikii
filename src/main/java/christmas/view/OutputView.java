package christmas.view;

import static christmas.constant.Constants.Common.*;
import static christmas.constant.Constants.OutputView.*;

import christmas.domain.Badge;
import christmas.domain.discount.Discount;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.discount.Discounts;
import christmas.domain.discount.Gift;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    public void printHeader(int date) {
        System.out.println(HEADER_FRONT + date + HEADER_BACK);
        System.out.println();
    }

    public void printResult(Order order, Discounts discounts) {
        printOrderMenu(order);
        printTotalPrice(order.getTotalPrice());
        printGiftMenu(discounts.findGift());
        printBenefitList(discounts);
        printBenefitPrice(discounts.getPrice());
        printAmountOfPayment(discounts.getAmountOfPayment(order));
        printBadge(discounts.getBadge());
    }

    private void printOrderMenu(Order order) {
        System.out.println(ALERT_ORDER_MENU);
        Map<Menu, Integer> orders = order.get();
        printMenu(orders);
        System.out.println();
    }

    private void printTotalPrice(int totalPrice) {
        System.out.println(ALERT_TOTAL_PRICE);
        printFormattedPrice(totalPrice);
        System.out.println();
    }

    private void printGiftMenu(Gift gift) {
        System.out.println(ALERT_GIFT_MENU);
        Map<Menu, Integer> gifts = gift.get();
        printMenu(gifts);
        if (gifts.isEmpty()) {
            System.out.println(X);
        }
        System.out.println();
    }

    private void printBenefitList(Discounts discounts) {
        System.out.println(ALERT_BENEFIT_LIST);
        int benefitPrice = discounts.getPrice();
        printDiscount(discounts);
        if (benefitPrice == ZERO) {
            System.out.println(X);
        }
        System.out.println();
    }

    private void printBenefitPrice(int benefitPrice) {
        System.out.println(ALERT_BENEFIT_PRICE);
        printMinusFormattedPrice(benefitPrice);
    }

    private void printAmountOfPayment(int amountOfPayment) {
        System.out.println(ALERT_PAYMENT_PRICE);
        String formattedPrice = getFormattedPrice(amountOfPayment);
        System.out.println(formattedPrice + WON);
        System.out.println();
    }

    private void printBadge(Badge badge) {
        System.out.println(ALERT_BADGE);
        System.out.print(badge.getName());
    }

    private void printMenu(Map<Menu, Integer> map) {
        map.forEach((menu, count)
                -> System.out.println(menu.getName() + SPACING + count + MENU_COUNT_UNIT));
    }

    private String getFormattedPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat(WON_FORMAT);
        String formattedPrice = decimalFormat.format(price);
        return formattedPrice;
    }

    private void printFormattedPrice(int price) {
        String formattedPrice = getFormattedPrice(price);
        System.out.println(formattedPrice + WON);
    }

    private void printMinusFormattedPrice(int price) {
        String formattedPrice = getFormattedPrice(price);
        if (price != ZERO) {
            formattedPrice = MINUS + formattedPrice;
        }
        System.out.println(formattedPrice + WON);
        System.out.println();
    }

    private void printDiscount(Discounts discounts) {
        for (Discount discount : discounts.get()) {
            Integer discountPrice = discount.getPrice();
            if(discountPrice != ZERO) {
                System.out.print(discount.getName() + COLON);
                printMinusFormattedPrice(discountPrice);
            }
        }
    }
}
