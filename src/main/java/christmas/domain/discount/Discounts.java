package christmas.domain.discount;

import christmas.domain.Badge;
import christmas.domain.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Discounts {
    private final List<Discount> discounts;

    public Discounts() {
        this.discounts = new ArrayList<>();
    }

    public List<Discount> get() {
        return this.discounts;
    }

    public void save(Discount... discount) {
        Arrays.stream(discount).forEach(this.discounts::add);
    }

    public void apply(int date, Order order) {
        if (order.getEventApply()) {
            discounts.stream()
                    .forEach(discount -> discount.calculate(date, order));
        }
    }

    public Integer getAmountOfPayment(Order order) {
        return order.getTotalPrice() - getBenefitPrice() + findGift().getPrice();
    }

    public Integer getBenefitPrice() {
        int benefitPrice = 0;
        for (Discount discount : discounts) {
            benefitPrice += discount.getPrice();
        }
        return benefitPrice;
    }

    public Gift findGift() {
        Optional<Discount> gift = discounts.stream()
                .filter(discount -> discount instanceof Gift)
                .findFirst();
        if (gift.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 증정 메뉴가 저장되지 않았습니다.");
        }
        return (Gift) gift.get();
    }

    public Badge getBadge() {
        return Badge.getBadge(getBenefitPrice());
    }
}
