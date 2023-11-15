package christmas.view;

import christmas.domain.Menu;
import christmas.domain.enums.Calendar;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void newLine() {
        System.out.println();
    }

    public static void printResult(int date, Map<String, Object> benefitInfo) {
        print(Message.RESPONSE_BENEFIT.getMessage(Calendar.PROMOTION_MONTH.getValue(), date));
        newLine();
        print(Message.TITLE_MENU.getMessage());
        ((List<Menu>) benefitInfo.get("menus")).forEach(Menu::printOrder);
        newLine();
        print(Message.TITLE_PRICE.getMessage());
        print(Message.KRW_FORMATTER.getMessage(benefitInfo.get("total_price")));
        newLine();
        print(Message.TITLE_GIFT.getMessage());
        ((Menu) benefitInfo.get("gift")).printOrder();
        newLine();
        print(Message.TITLE_BENEFIT.getMessage());
        ((Map<String, Integer>) benefitInfo.get("total_benefit")).forEach((key, value)
                -> print(String.format("%s: -%s", key, Message.KRW_FORMATTER.getMessage(value))));
        newLine();
        print(Message.TITLE_BENEFIT_DISCOUNT.getMessage());
        print(String.format("-%s", Message.KRW_FORMATTER.getMessage(benefitInfo.get("total_benefit_value"))));
        newLine();
        print(Message.TITLE_PAYMENT.getMessage());
        print(Message.KRW_FORMATTER.getMessage(
                (int) benefitInfo.get("total_price") - (int) benefitInfo.get("total_benefit_value")));
        newLine();
        print(Message.TITLE_BADGE.getMessage());
        print((String)benefitInfo.get("badge"));
    }

    public static void print(String text) {
        System.out.println(text);
    }
}