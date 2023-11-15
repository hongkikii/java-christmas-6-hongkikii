package christmas.domain.discount;

import christmas.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayTest {

    private Order order;
    private int weekdayDate = 7;
    private int weekendDate = 8;
    private String oneDesertTwoCount = "티본스테이크-1,초코케이크-2";
    private String twoDesertOneCount = "티본스테이크-1,초코케이크-1,아이스크림-1";

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @DisplayName("평일에는 평일 할인을 적용한다.")
    @Test
    void checkWeekday() {
        order.save(oneDesertTwoCount);
        Weekday weekday = applyDiscount(weekdayDate);
        Assertions.assertThat(weekday.getPrice()).isNotEqualTo(0);
    }

    @DisplayName("주말에는 평일 할인을 적용하지 않는다.")
    @Test
    void checkWeekend() {
        order.save(oneDesertTwoCount);
        Weekday weekday = applyDiscount(weekendDate);
        Assertions.assertThat(weekday.getPrice()).isEqualTo(0);
    }

    @DisplayName("디저트 메뉴 1개당 2023원씩 할인을 적용한다. - 같은 디저트")
    @Test
    void checkSameMenuDiscount() {
        order.save(oneDesertTwoCount);
        Weekday weekday = applyDiscount(weekdayDate);
        Assertions.assertThat(weekday.getPrice()).isEqualTo(4046);
    }

    @DisplayName("디저트 메뉴 1개당 2023원씩 할인을 적용한다. - 다른 디저트")
    @Test
    void checkDifferentMenuDiscount() {
        order.save(twoDesertOneCount);
        Weekday weekday = applyDiscount(weekdayDate);
        Assertions.assertThat(weekday.getPrice()).isEqualTo(4046);
    }

    Weekday applyDiscount(int date) {
        Weekday result = new Weekday();
        result.calculate(date, order);
        return result;
    }
}
