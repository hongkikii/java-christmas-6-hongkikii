package christmas.domain;

import static christmas.constant.Constants.Menu.*;
import static christmas.domain.Menu.Type.*;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP(MUSHROOM_SOUP_NAME, APPETIZER, 6000),
    TAPAS(TAPAS_NAME, APPETIZER, 5500),
    CAESAR_SALAD(CAESAR_SALAD_NAME, APPETIZER, 8000),
    T_BONE_STAKE(T_BONE_STAKE_NAME, MAIN, 55000),
    BBQ_RIBS(BBQ_RIBS_NAME, MAIN, 54000),
    SEAFOOD_PASTA(SEAFOOD_PASTA_NAME, MAIN, 35000),
    CHRISTMAS_PASTA(CHRISTMAS_PASTA_NAME, MAIN, 25000),
    CHOCOLATE_CAKE(CHOCOLATE_CAKE_NAME, DESERT, 15000),
    ICE_CREAM(ICE_CREAM_NAME, DESERT, 5000),
    ZERO_COLA(ZERO_COLA_NAME, DRINK, 3000),
    RED_WINE(RED_WINE_NAME, DRINK, 60000),
    CHAMPAGNE(CHAMPAGNE_NAME, DRINK, 25000);

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
