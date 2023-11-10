package christmas.domain;

public enum Badge {
    STAR("별", 5000, 9999),
    TREE("트리", 10000, 19999),
    SANTA("산타", 20000, 100000); // 총혜택 금액 최대 제대로 계산하기

    private String name;
    private Integer minPrice;
    private Integer maxPrice;

    Badge(String name, Integer minPrice, Integer maxPrice) {
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getName() {
        return this.name;
    }
}
