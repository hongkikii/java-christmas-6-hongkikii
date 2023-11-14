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
import java.util.List;
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
        printBenefitList(discounts.get());
        printBenefitPrice(discounts.getBenefitPrice());
        printAmountOfPayment(discounts.getAmountOfPayment(order));
        printBadge(discounts.getBadge());
    }

    private void printOrderMenu(Order order) {
        System.out.println(ORDER_MENU);
        Map<Menu, Integer> orders = order.get();
        printMenu(orders);
        System.out.println();
    }

    private void printTotalPrice(int totalPrice) {
        System.out.println(TOTAL_PRICE);
        String formattedPrice = getFormattedPrice(totalPrice);
        System.out.println(formattedPrice + WON);
        System.out.println();
    }

    private void printGiftMenu(Gift gift) {
        System.out.println(GIFT_MENU);
        Map<Menu, Integer> gifts = gift.get();
        printMenu(gifts);
        if (gifts.isEmpty()) {
            System.out.println(X);
        }
        System.out.println();
    }

    private void printBenefitList(List<Discount> discounts) {
        System.out.println(BENEFIT_LIST);
        int totalDiscountPrice = printDiscount(discounts);
        if (totalDiscountPrice == ZERO) {
            System.out.println(X);
        }
        System.out.println();
    }

    private void printBenefitPrice(int benefitPrice) {
        System.out.println(BENEFIT_PRICE);
        String formattedPrice = getFormattedPrice(benefitPrice);
        if (benefitPrice != ZERO) {
            formattedPrice = MINUS + formattedPrice;
        }
        System.out.println(formattedPrice + WON);
        System.out.println();
    }

    private void printAmountOfPayment(int amountOfPayment) {
        System.out.println(PAYMENT_PRICE);
        String formattedPrice = getFormattedPrice(amountOfPayment);
        System.out.println(formattedPrice + WON);
        System.out.println();
    }

    private void printBadge(Badge badge) {
        System.out.println(BADGE);
        System.out.println(badge.getName());
    }

    private String getFormattedPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat(WON_FORMAT);
        String formattedPrice = decimalFormat.format(price);
        return formattedPrice;
    }

    private void printMenu(Map<Menu, Integer> map) {
        map.forEach((menu, count)
                -> System.out.println(menu.getName() + SPACING + count + MENU_COUNT_UNIT));
    }

    private int printDiscount(List<Discount> discounts) {
        int totalDiscountPrice = ZERO;
        for (Discount discount : discounts) {
            Integer discountPrice = discount.getPrice();
            if(discountPrice != ZERO) {
                System.out.print(discount.getName() + COLON);
                String formattedPrice = getFormattedPrice(discount.getPrice());
                System.out.println(MINUS + formattedPrice + WON);
                totalDiscountPrice += discountPrice;
            }
        }
        return totalDiscountPrice;
    }
}
