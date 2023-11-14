package christmas.domain;

import static christmas.constant.Constants.Menu.*;
import static christmas.domain.Menu.Type.*;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP(MUSHROOM_SOUP_NAME, APPETIZER, MUSHROOM_SOUP_PRICE),
    TAPAS(TAPAS_NAME, APPETIZER, TAPAS_PRICE),
    CAESAR_SALAD(CAESAR_SALAD_NAME, APPETIZER, CAESAR_SALAD_PRICE),
    T_BONE_STAKE(T_BONE_STAKE_NAME, MAIN, T_BONE_STAKE_PRICE),
    BBQ_RIBS(BBQ_RIBS_NAME, MAIN, BBQ_RIBS_PRICE),
    SEAFOOD_PASTA(SEAFOOD_PASTA_NAME, MAIN, SEAFOOD_PASTA_PRICE),
    CHRISTMAS_PASTA(CHRISTMAS_PASTA_NAME, MAIN, CHRISTMAS_PASTA_PRICE),
    CHOCOLATE_CAKE(CHOCOLATE_CAKE_NAME, DESERT, CHOCOLATE_CAKE_PRICE),
    ICE_CREAM(ICE_CREAM_NAME, DESERT, ICE_CREAM_PRICE),
    ZERO_COLA(ZERO_COLA_NAME, DRINK, ZERO_COLA_PRICE),
    RED_WINE(RED_WINE_NAME, DRINK, RED_WINE_PRICE),
    CHAMPAGNE(CHAMPAGNE_NAME, DRINK, CHAMPAGNE_PRICE);

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
