package christmas.domain;

import christmas.domain.discount.Discount;
import java.util.List;

public class Event {
    private List<Discount> discounts;
    // 증정, 배지


    public List<Discount> getDiscounts() {
        return discounts;
    }

    public Integer getBenefitPrice() {
        int result = 0;
        for (Discount discount : discounts) {
            result += discount.getPrice();
        }
        return result;
    }
}
