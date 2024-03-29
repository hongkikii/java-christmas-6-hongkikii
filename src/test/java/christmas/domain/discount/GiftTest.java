package christmas.domain.discount;


import static org.assertj.core.api.Assertions.*;

import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftTest {
    private Order order;
    private int normalDate = 3;
    private String giftMenu = "시저샐러드-1,티본스테이크-1,바비큐립-1,초코케이크-1,레드와인-1";
    private String noGiftMenu = "시저샐러드-1,레드와인-1";

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @DisplayName("할인 전 총주문 금액이 12만원 이상일 때 증정 이벤트를 적용한다.")
    @Test
    void checkWeekend() {
        order.save(giftMenu);
        Gift gift = new Gift();
        gift.calculate(normalDate, order);
        assertThat(gift.getPrice()).isNotEqualTo(0);
    }

    @DisplayName("할인 전 총주문 금액이 12만원 미만일 때 증정 이벤트를 적용하지 않는다.")
    @Test
    void checkWeekday() {
        expectEqual(noGiftMenu, normalDate, 0);
    }

    @DisplayName("샴페인 1개 금액의 할인을 적용한다.")
    @Test
    void checkSameMenuDiscount() {
        expectEqual(giftMenu, normalDate, 25000);
    }

    void expectEqual(String menu, int date, int result) {
        order.save(menu);
        Gift gift = new Gift();
        gift.calculate(date, order);
        assertThat(gift.getPrice()).isEqualTo(result);
    }
}
