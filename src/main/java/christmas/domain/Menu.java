package christmas.domain;

import static christmas.domain.Menu.Type.*;

import java.util.Arrays;

public enum Menu {
    SOUP("양송이수프", APPETIZER, 6000),
    TAPAS("타파스", APPETIZER, 5500),
    SALAD("시저샐러드", APPETIZER, 8000),
    STAKE("티본스테이크", MAIN, 55000),
    RIB("바비큐립", MAIN, 54000),
    SEAFOOD_PASTA("해산물파스타", MAIN, 35000),
    CHRISTMAS_PASTA("크리스마스파스타", MAIN, 25000),
    CAKE("초코케이크", DESERT, 15000),
    ICE_CREAM("아이스크림", DESERT, 5000),
    COLA("제로콜라", DRINK, 3000),
    WINE("레드와인", DRINK, 60000),
    CHAMPAGNE("샴페인", DRINK, 25000);

    private String name;
    private Type type;
    private int price;

    Menu(String name, Type type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public Integer getPrice() {
        return this.price;
    }

    public static Menu findMenu(String orderMenu) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equals(orderMenu))
                .findFirst()
                .orElse(null);
    }

    public enum Type {
        APPETIZER,
        MAIN,
        DESERT,
        DRINK
    }
}
