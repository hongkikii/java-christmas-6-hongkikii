package christmas.domain.discount;

import static org.assertj.core.api.Assertions.*;

import christmas.domain.Order;
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
        Weekday weekday = new Weekday();
        weekday.calculate(weekdayDate, order);
        assertThat(weekday.getPrice()).isNotEqualTo(0);
    }

    @DisplayName("주말에는 평일 할인을 적용하지 않는다.")
    @Test
    void checkWeekend() {
        expectEqual(oneDesertTwoCount, weekendDate, 0);
    }

    @DisplayName("디저트 메뉴 1개당 2023원씩 할인을 적용한다. - 같은 디저트")
    @Test
    void checkSameMenuDiscount() {
        expectEqual(oneDesertTwoCount, weekdayDate, 4046);
    }

    @DisplayName("디저트 메뉴 1개당 2023원씩 할인을 적용한다. - 다른 디저트")
    @Test
    void checkDifferentMenuDiscount() {
        expectEqual(twoDesertOneCount, weekdayDate, 4046);
    }

    void expectEqual(String menu, int date, int result) {
        order.save(menu);
        Weekday weekday = new Weekday();
        weekday.calculate(date, order);
        assertThat(weekday.getPrice()).isEqualTo(result);
    }
}
