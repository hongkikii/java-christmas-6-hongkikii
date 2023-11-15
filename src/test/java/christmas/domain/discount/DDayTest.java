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

    @DisplayName("1~25일 동안 이벤트를 적용한다.")
    @Test
    void checkEventPeriod() {
        expectNotEqual(1,0);
        expectNotEqual(25, 0);
    }

    void expectNotEqual(int date, int result) {
        DDay dDay = new DDay();
        dDay.calculate(date, order);
        assertThat(dDay.getPrice()).isNotEqualTo(result);
    }

    @DisplayName("26~31일은 이벤트가 적용되지 않는다.")
    @Test
    void checkNotEventPeriod() {
        expectEqual(26, 0);
        expectEqual(31, 0);
    }

    @DisplayName("1000원부터 시작하여 25일까지 매일 할인 금액이 100원씩 증가한다.")
    @Test
    void checkDiscount() {
        expectEqual(1, 1000);
        expectEqual(25, 3400);
    }

    void expectEqual(int date, int result) {
        DDay dDay = new DDay();
        dDay.calculate(date, order);
        assertThat(dDay.getPrice()).isEqualTo(result);
    }
}
