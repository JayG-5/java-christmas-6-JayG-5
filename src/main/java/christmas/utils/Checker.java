package christmas.utils;

import christmas.domain.Menu;
import christmas.domain.enums.Category;
import christmas.exception.Message;
import christmas.exception.PromotionException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public static void isOnlyCategory(List<Menu> menus,int category) {
        Set<Integer> uniqueCategories = menus.stream()
                .map(Menu::getCategory)
                .collect(Collectors.toSet());

        if (uniqueCategories.size() == 1 && uniqueCategories.contains(category)) {
            throw PromotionException.of(Message.ORDER);
        }
    }
}