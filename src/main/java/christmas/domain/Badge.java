package christmas.domain;

import static christmas.constant.Constants.Badge.*;
import static christmas.constant.Constants.Common.*;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {
    STAR(STAR_NAME, STAR_MIN_PRICE),
    TREE(TREE_NAME, TREE_MIN_PRICE),
    SANTA(SANTA_NAME, SANTA_MIN_PRICE),
    NONE(X, ZERO);

    private final String name;
    private final Integer minPrice;
    private static final Comparator<Badge> BADGE_BY_PRICE = Comparator.comparing(Badge::getMinPrice).reversed();

    Badge(String name, Integer minPrice) {
        this.name = name;
        this.minPrice = minPrice;
    }

    public String getName() {
        return this.name;
    }

    private Integer getMinPrice() {
        return this.minPrice;
    }

    public static Badge getBadge(Integer benefitPrice) {
        return Arrays.stream(Badge.values())
                .sorted(BADGE_BY_PRICE)
                .filter(badge -> benefitPrice >= badge.minPrice)
                .findFirst()
                .orElse(NONE);
    }
}
