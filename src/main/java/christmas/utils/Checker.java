package christmas.utils;

import christmas.domain.Menu;
import christmas.exception.Message;
import christmas.exception.PromotionException;

import java.util.List;

public class Checker {
    public static void isBetween1And31(int number) {
        if (number < 1 || number > 31) {
            throw PromotionException.of(Message.NUMBER);
        }
    }
    public static void isOverMinimumPrice(List<Menu> menus) {
        if (menus.stream().mapToInt(Menu::getPrice).sum() < 10000) {
            throw PromotionException.of(Message.ORDER);
        }
    }
}
