package christmas;


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
        dDay.calculate(inputView.getDate(), order);
        discounts.add(dDay);

        Weekday weekday = new Weekday("평일 할인");
        weekday.calculate(inputView.getDate(), order);
        discounts.add(weekday);

        Weekend weekend = new Weekend("주말 할인");
        weekend.calculate(inputView.getDate(), order);
        discounts.add(weekend);

        Special special = new Special("특별 할인");
        special.calculate(inputView.getDate(), order);
        discounts.add(special);

        Gift gift = new Gift("증정 이벤트");
        gift.calculate(inputView.getDate(), order);
        discounts.add(gift);

        outputView.printGiftMenu(gift);
        outputView.printBenefitList(discounts);

        int benefitPrice = 0;
        for (Discount discount : discounts) {
            benefitPrice += discount.getPrice();
        }
        outputView.printBenefitPrice(benefitPrice);
    }
}
