package christmas.domain;

import static christmas.constant.Constants.Badge.*;
import static christmas.constant.Constants.Common.X;

public enum Badge {
    STAR(STAR_NAME, 5000),
    TREE(TREE_NAME, 10000),
    SANTA(SANTA_NAME, 20000),
    NONE(X, 0);

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
