package christmas.domain.enums;

import christmas.domain.Menu;
import christmas.exception.Message;
import christmas.exception.PromotionException;

import java.util.Arrays;

public enum MenuItem {
    // 애피타이저
    YANGSONGHI_SOUP("양송이수프", 6000, Category.APPETIZER.getType()),
    TAPAS("타파스", 5500, Category.APPETIZER.getType()),
    CAESAR_SALAD("시저샐러드", 8000, Category.APPETIZER.getType()),

    // 메인
    T_BONE_STEAK("티본스테이크", 55000, Category.MAIN.getType()),
    BBQ_RIBS("바비큐립", 54000, Category.MAIN.getType()),
    SEAFOOD_PASTA("해산물파스타", 35000, Category.MAIN.getType()),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, Category.MAIN.getType()),

    // 디저트
    CHOCOLATE_CAKE("초코케이크", 15000, Category.DESSERT.getType()),
    ICE_CREAM("아이스크림", 5000, Category.DESSERT.getType()),

    // 음료
    ZERO_COLA("제로콜라", 3000, Category.BEVERAGE.getType()),
    RED_WINE("레드와인", 60000, Category.BEVERAGE.getType()),
    CHAMPAGNE("샴페인", 25000, Category.BEVERAGE.getType());

    private final String name;
    private final int price;
    private final int category;

    MenuItem(String name, int price, int category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Menu getMenu(int unit) {
        return new Menu(0, name, unit);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCategory() {
        return category;
    }

    public static int getPriceByName(String name) {
        for (MenuItem item : MenuItem.values()) {
            if (item.getName().equals(name)) {
                return item.getPrice();
            }
        }
        throw PromotionException.of(Message.ORDER);
    }

    public static int getCategoryByName(String name) {
        for (MenuItem item : MenuItem.values()) {
            if (item.getName().equals(name)) {
                return item.getCategory();
            }
        }
        throw PromotionException.of(Message.ORDER);
    }
}