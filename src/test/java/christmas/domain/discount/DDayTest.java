package christmas.domain.discount;

import static org.assertj.core.api.Assertions.*;

import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DDayTest {
    private Order order;
    private String orderLine = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

    @BeforeEach
    void setUp() {
        order = new Order();
        order.save(orderLine);
    }

    @DisplayName("이벤트 기간은 1~25일 사이이다.")
    @Test
    void checkEventPeriod() {
        DDay dDay26 = applyDDayDiscount(26);
        assertThat(dDay26.getPrice()).isEqualTo(0);
    }

    @DisplayName("1000원부터 시작하여 25일까지 매일 할인 금액이 100원씩 증가한다.")
    @Test
    void checkDiscount() {
        DDay dDay1 = applyDDayDiscount(1);
        assertThat(dDay1.getPrice()).isEqualTo(1000);

        DDay dDay25 = applyDDayDiscount(25);
        assertThat(dDay25.getPrice()).isEqualTo(3400);
    }

    DDay applyDDayDiscount(int date) {
        DDay result = new DDay();
        result.calculate(date, order);
        return result;
    }
}
