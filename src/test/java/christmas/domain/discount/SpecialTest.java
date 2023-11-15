package christmas.domain.discount;

import christmas.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialTest {

    private Order order;
    private int specialDate = 3;
    private int noSpecialDate = 7;
    private String menu = "티본스테이크-2,초코케이크-1";

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @DisplayName("별이 표시된 날에는 특별 할인을 적용한다.")
    @Test
    void checkWeekend() {
        order.save(menu);
        Special special = applyDiscount(specialDate);
        Assertions.assertThat(special.getPrice()).isNotEqualTo(0);
    }

    @DisplayName("별이 표시되지 않은 날에는 특별 할인을 적용하지 않는다.")
    @Test
    void checkWeekday() {
        order.save(menu);
        Special special = applyDiscount(noSpecialDate);
        Assertions.assertThat(special.getPrice()).isEqualTo(0);
    }

    @DisplayName("1000원의 할인을 적용한다.")
    @Test
    void checkSameMenuDiscount() {
        order.save(menu);
        Special special = applyDiscount(specialDate);
        Assertions.assertThat(special.getPrice()).isEqualTo(1000);
    }

    Special applyDiscount(int date) {
        Special result = new Special();
        result.calculate(date, order);
        return result;
    }
}
