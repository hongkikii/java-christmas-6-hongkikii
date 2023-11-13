package christmas;


import static christmas.domain.Badge.*;

import christmas.domain.Badge;
import christmas.domain.Order;
import christmas.domain.discount.DDay;
import christmas.domain.discount.Discount;
import christmas.domain.discount.Gift;
import christmas.domain.discount.Special;
import christmas.domain.discount.Weekday;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static Integer date = 0;
    private static Order order = new Order();
    private static List<Discount> discounts = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        saveInput();
        getDiscount();
        showResult();
    }

    private static void saveInput() {
        inputView.run();
        date = inputView.getDate();
        order = inputView.getOrder();
    }

    private static void getDiscount() {
        saveDiscount(new DDay(), new Weekday(), new Special(), new Gift());
        applyDiscount();
    }

    private static void saveDiscount(Discount... discount) {
        Arrays.stream(discount).forEach(discounts::add);
    }

    private static void applyDiscount() {
        if (order.getEventApply()) {
            discounts.stream()
                    .forEach(discount -> discount.calculate(date, order));
        }
    }

    private static void showResult() {
        Gift gift = findGift();
        Integer benefitPrice = getBenefitPrice();
        Integer amountOfPayment = order.getTotalPrice() - benefitPrice + gift.getPrice();

        outputView.printHeader(date);
        outputView.printOrder(order);
        outputView.printGiftMenu(gift);
        outputView.printBenefitList(discounts);
        outputView.printBenefitPrice(benefitPrice);
        outputView.printAmountOfPayment(amountOfPayment);
        outputView.printBadge(getBadge(benefitPrice));
    }

    private static Gift findGift() {
        Optional<Discount> gift = discounts.stream()
                .filter(discount -> discount instanceof Gift)
                .findFirst();
        if (gift.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 증정 메뉴가 저장되지 않았습니다.");
        }
        return (Gift) gift.get();
    }

    private static Integer getBenefitPrice() {
        int benefitPrice = 0;
        for (Discount discount : discounts) {
            benefitPrice += discount.getPrice();
        }
        return benefitPrice;
    }
}
