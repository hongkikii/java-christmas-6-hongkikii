package christmas;


import christmas.domain.Order;
import christmas.domain.discount.DDay;
import christmas.domain.discount.Discounts;
import christmas.domain.discount.Gift;
import christmas.domain.discount.Special;
import christmas.domain.discount.Weekday;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final Discounts discounts = new Discounts();
    private static Integer date;
    private static Order order;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        saveDateAndOrder();
        getDiscounts();
        showResult();
    }

    private static void saveDateAndOrder() {
        inputView.run();
        date = inputView.getDate();
        order = inputView.getOrder();
    }

    private static void getDiscounts() {
        discounts.save(new DDay(), new Weekday(), new Special(), new Gift());
        discounts.apply(date, order);
    }

    private static void showResult() {
        outputView.printHeader(date);
        outputView.printResult(order, discounts);
    }
}
