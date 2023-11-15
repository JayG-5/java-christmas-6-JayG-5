package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.Promotion;
import christmas.domain.Menu;
import christmas.domain.enums.Category;
import christmas.exception.PromotionException;
import christmas.utils.Checker;
import christmas.utils.Parser;

import java.util.List;
import java.util.function.Function;

public class InputView {
    public static int readDate() {
        return inputHandler(Message.REQUEST_DATE, input -> {
            try {
                int date = Parser.stringToInt(input);
                Checker.isBetween1And31(date);
                return date;
            } catch (NumberFormatException e) {
                throw PromotionException.of(christmas.exception.Message.NUMBER);
            }
        });
    }

    public static List<Menu> readMenu(int date) {
        return inputHandler(Message.REQUEST_MENU, input -> {
            final List<String> orders = Parser.splitToList(input, ",");
            Checker.isUniqueOrder(orders);
            final List<Menu> menus = orders.stream().map(menuText -> Promotion.createMenu(date, menuText)).toList();
            Checker.isOverMenuSize(menus, 20);
            Checker.isOnlyCategory(menus, Category.BEVERAGE.getType());
            return menus;
        });
    }


    private static <T> T inputHandler(Message message, Function<String, T> func) {
        while (true) {
            try {
                OutputView.print(message.getMessage());
                final String input = Console.readLine();
                return func.apply(input);
            } catch (PromotionException ignored) {
            }
        }
    }
}