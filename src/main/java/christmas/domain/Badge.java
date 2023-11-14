package christmas.domain;

import static christmas.constant.Constants.Badge.*;
import static christmas.constant.Constants.Common.*;

public enum Badge {
    STAR(STAR_NAME, STAR_MIN_PRICE),
    TREE(TREE_NAME, TREE_MIN_PRICE),
    SANTA(SANTA_NAME, SANTA_MIN_PRICE),
    NONE(X, ZERO);

    private String name;
    private Integer minPrice;

    Badge(String name, Integer minPrice) {
        this.name = name;
        this.minPrice = minPrice;
    }

    public String getName() {
        return this.name;
    }

    public static Badge getBadge(Integer benefitPrice) {
        if (benefitPrice >= STAR.minPrice && benefitPrice < TREE.minPrice) {
            return STAR;
        }
        if (benefitPrice >= TREE.minPrice && benefitPrice < SANTA.minPrice) {
            return TREE;
        }
        if (benefitPrice >= SANTA.minPrice) {
            return SANTA;
        }
        return NONE;
    }
}
