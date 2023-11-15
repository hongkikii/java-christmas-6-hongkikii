package christmas.domain.discount;

import static org.assertj.core.api.Assertions.*;

import christmas.domain.Order;
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
        Weekend weekend = new Weekend();
        weekend.calculate(weekendDate, order);
        assertThat(weekend.getPrice()).isNotEqualTo(0);
    }

    @DisplayName("평일에는 주말 할인을 적용하지 않는다.")
    @Test
    void checkWeekday() {
        expectEqual(oneMainTwoCount, weekdayDate, 0);
    }

    @DisplayName("메인 메뉴 1개당 2023원씩 할인을 적용한다. - 같은 메인")
    @Test
    void checkSameMenuDiscount() {
        expectEqual(oneMainTwoCount, weekendDate, 4046);
    }

    @DisplayName("메인 메뉴 1개당 2023원씩 할인을 적용한다. - 다른 메인")
    @Test
    void checkDifferentMenuDiscount() {
        expectEqual(twoMainOneCount, weekendDate, 4046);
    }

    void expectEqual(String menu, int date, int result) {
        order.save(menu);
        Weekend weekend = new Weekend();
        weekend.calculate(date, order);
        assertThat(weekend.getPrice()).isEqualTo(result);
    }
}
