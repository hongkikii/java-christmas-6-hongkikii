package christmas.domain.discount;

import static org.assertj.core.api.Assertions.*;

import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountsTest {
    private Order order;
    private Discounts discounts;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.save("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        discounts = new Discounts();
        discounts.save(new DDay(), new Weekday(), new Weekend(), new Special(), new Gift());
        discounts.apply(3, order);
    }

    @DisplayName("총혜택 금액은 할인 금액의 합계에 증정 메뉴의 가격이 더해진 값이다.")
    @Test
    void getBenefitPrice() {
        int benefitPrice = discounts.getPrice();
        assertThat(benefitPrice).isEqualTo(31246);
    }

    @DisplayName("할인 후 예상 결제 금액은 할인 전 총주문 금액에서 할인 금액을 뺀 값이다.")
    @Test
    void getAmountOfPayment() {
        int payPrice = discounts.getAmountOfPayment(order);
        assertThat(payPrice).isEqualTo(135754);
    }
}
