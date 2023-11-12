package christmas.domain;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NONE("없음", 0);

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
