package christmas.domain.discount;

import static christmas.constant.Constants.Common.*;

import christmas.domain.Badge;
import christmas.domain.Order;
import java.util.ArrayList;
import java.util.Collections;
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
        Collections.addAll(this.discounts, discount);
    }

    public void apply(int date, Order order) {
        if (order.getEventApply()) {
            discounts.forEach(discount -> discount.calculate(date, order));
        }
    }

    public Integer getAmountOfPayment(Order order) {
        return order.getTotalPrice() - getPrice() + findGift().getPrice();
    }

    public Integer getPrice() {
        int benefitPrice = ZERO;
        for (Discount discount : discounts) {
            benefitPrice += discount.getPrice();
        }
        return benefitPrice;
    }

    public Gift findGift() {
        Optional<Discount> gift = discounts.stream()
                .filter(discount -> discount instanceof Gift)
                .findFirst();
        return (Gift) gift.get();
    }

    public Badge getBadge() {
        return Badge.getBadge(getPrice());
    }
}
