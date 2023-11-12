package christmas;


import christmas.domain.Badge;
import christmas.domain.Order;
import christmas.domain.discount.DDay;
import christmas.domain.discount.Discount;
import christmas.domain.discount.Gift;
import christmas.domain.discount.Special;
import christmas.domain.discount.Weekday;
import christmas.domain.discount.Weekend;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        inputView.introduce();
        inputView.readDate();
        inputView.readOrder();

        OutputView outputView = new OutputView();
        outputView.printHeader(inputView.getDate());

        Order order = new Order();
        order.save(inputView.getOrder());
        outputView.printMenu(order);

        outputView.printTotalPrice(order.getTotalPrice());

        List<Discount> discounts = new ArrayList<>();

        DDay dDay = new DDay("크리스마스 디데이 할인");
        discounts.add(dDay);

        Weekday weekday = new Weekday("평일 할인");
        discounts.add(weekday);

        Weekend weekend = new Weekend("주말 할인");
        discounts.add(weekend);

        Special special = new Special("특별 할인");
        discounts.add(special);

        Gift gift = new Gift("증정 이벤트");
        discounts.add(gift);

        if (order.getEventApply()) {
            dDay.calculate(inputView.getDate(), order);
            weekday.calculate(inputView.getDate(), order);
            weekend.calculate(inputView.getDate(), order);
            special.calculate(inputView.getDate(), order);
            gift.calculate(inputView.getDate(), order);
        }

        outputView.printGiftMenu(gift);
        outputView.printBenefitList(discounts);

        int benefitPrice = 0;
        for (Discount discount : discounts) {
            benefitPrice += discount.getPrice();
        }
        outputView.printBenefitPrice(benefitPrice);

        int amountOfPayment = order.getTotalPrice() - benefitPrice + gift.getPrice();
        outputView.printAmountOfPayment(amountOfPayment);

        Badge badge = Badge.getBadge(benefitPrice);
        outputView.printBadge(badge);
    }
}
