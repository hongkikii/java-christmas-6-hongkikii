package christmas.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    private String noEventApplyMenu = "시저샐러드-1";
    private String eventApplyMenu = "시저샐러드-1,바비큐립-2";
    private String onlyDrinkOrder = "레드와인-1";
    private String exceedMaxCountOrder = "바비큐립-16,레드와인-5";

    @DisplayName("총주문 금액 10000원 이상부터 이벤트가 적용된다.")
    @Test
    void checkApplyEventPrice() {
        Order order = new Order();
        order.save(eventApplyMenu);
        boolean eventApply = order.getEventApply();
        assertThat(eventApply).isTrue();
    }

    @DisplayName("총주문 금액 10000원 미만은 이벤트가 적용되지 않는다.")
    @Test
    void checkNoApplyEventPrice() {
        Order order = new Order();
        order.save(noEventApplyMenu);
        boolean eventApply = order.getEventApply();
        assertThat(eventApply).isFalse();
    }

    @DisplayName("음료만 주문할 시 예외가 발생한다.")
    @Test
    void checkOrderOnlyDrink() {
        Order order = new Order();
        assertThatThrownBy(() -> order.save(onlyDrinkOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 주문 수량은 최대 20개이다.")
    @Test
    void checkMaxOrderCount() {
        Order order = new Order();
        assertThatThrownBy(() -> order.save(exceedMaxCountOrder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총주문 금액은 할인 적용 전 주문 메뉴 (가격 * 수량)의 단순 합이다.")
    @Test
    void printTotalOrderPrice() {
        Order order = new Order();
        order.save(eventApplyMenu);
        int totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(116000);
    }
}
