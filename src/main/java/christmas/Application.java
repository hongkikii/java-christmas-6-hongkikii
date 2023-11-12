package christmas;


import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

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

    }
}
