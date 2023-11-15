package christmas.domain.discount;

import christmas.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendTest {

    private Order order;
    private int weekdayDate = 7;
    private int weekendDate = 8;
    private String oneMainTwoCount = "티본스테이크-2,초코케이크-1";
    private String twoMainOneCount = "티본스테이크-1,바비큐립-1";

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @DisplayName("주말에는 주말 할인을 적용한다.")
    @Test
    void checkWeekend() {
        order.save(oneMainTwoCount);
        Weekend weekend = applyDiscount(weekendDate);
        Assertions.assertThat(weekend.getPrice()).isNotEqualTo(0);
    }

    @DisplayName("평일에는 주말 할인을 적용하지 않는다.")
    @Test
    void checkWeekday() {
        order.save(oneMainTwoCount);
        Weekend weekend = applyDiscount(weekdayDate);
        Assertions.assertThat(weekend.getPrice()).isEqualTo(0);
    }

    @DisplayName("메인 메뉴 1개당 2023원씩 할인을 적용한다. - 같은 메인")
    @Test
    void checkSameMenuDiscount() {
        order.save(oneMainTwoCount);
        Weekend weekend = applyDiscount(weekendDate);
        Assertions.assertThat(weekend.getPrice()).isEqualTo(4046);
    }

    @DisplayName("메인 메뉴 1개당 2023원씩 할인을 적용한다. - 다른 메인")
    @Test
    void checkDifferentMenuDiscount() {
        order.save(twoMainOneCount);
        Weekend weekend = applyDiscount(weekendDate);
        Assertions.assertThat(weekend.getPrice()).isEqualTo(4046);
    }

    Weekend applyDiscount(int date) {
        Weekend result = new Weekend();
        result.calculate(date, order);
        return result;
    }
}
