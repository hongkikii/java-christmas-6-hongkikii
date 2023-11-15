package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @DisplayName("총혜택 금액이 2만원 이상일 때 산타 배지를 부여한다")
    @Test
    void giveSanta() {
        applyBadge(20000, "산타");
    }

    @DisplayName("총혜택 금액이 1만원 이상일 때 트리 배지를 부여한다")
    @Test
    void giveTree() {
        applyBadge(10000, "트리");
    }

    @DisplayName("총혜택 금액이 5천원 이상일 때 별 배지를 부여한다")
    @Test
    void giveStar() {
        applyBadge(5000, "별");
    }

    @DisplayName("총혜택 금액이 5천원 미만일 때 '없음'을 출력한다")
    @Test
    void giveNone() {
        applyBadge(4999, "없음");
    }

    void applyBadge(int benefitPrice, String result) {
        Badge badge = Badge.getBadge(benefitPrice);
        Assertions.assertThat(badge.getName()).isEqualTo(result);
    }
}
