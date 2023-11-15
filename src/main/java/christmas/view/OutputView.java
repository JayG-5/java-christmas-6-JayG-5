package christmas.view;

import christmas.domain.Menu;
import christmas.domain.enums.Calendar;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void newLine() {
        System.out.println();
    }

    private static void printMenu(int date, Map<String, Object> benefitInfo) {
        print(Message.RESPONSE_BENEFIT.getMessage(Calendar.PROMOTION_MONTH.getValue(), date));
        newLine();
        print(Message.TITLE_MENU.getMessage());
        ((List<Menu>) benefitInfo.get("menus")).forEach(Menu::printOrder);
    }

    private static void printTotalPrice(Map<String, Object> benefitInfo) {
        newLine();
        print(Message.TITLE_PRICE.getMessage());
        print(Message.KRW_FORMATTER.getMessage(benefitInfo.get("total_price")));
    }

    private static void printGift(Map<String, Object> benefitInfo) {
        newLine();
        print(Message.TITLE_GIFT.getMessage());
        try {
            ((Menu) benefitInfo.get("gift")).printOrder();
        } catch (NullPointerException e) {
            print("없음");
        }
    }

    private static void printBenefitList(Map<String, Object> benefitInfo) {
        newLine();
        print(Message.TITLE_BENEFIT.getMessage());
        ((Map<String, Integer>) benefitInfo.get("total_benefit")).forEach((key, value)
                -> print(String.format("%s: -%s", key, Message.KRW_FORMATTER.getMessage(value))));
    }

    private static void printBenefitValue(Map<String, Object> benefitInfo) {
        newLine();
        print(Message.TITLE_BENEFIT_DISCOUNT.getMessage());
        print(Message.KRW_FORMATTER.getMessage(-(int) benefitInfo.get("total_benefit_value")));
    }

    private static void printPayment(Map<String, Object> benefitInfo) {
        newLine();
        print(Message.TITLE_PAYMENT.getMessage());
        print(Message.KRW_FORMATTER.getMessage(
                (int) benefitInfo.get("total_price") - (int) benefitInfo.get("total_discount_value")));
    }

    private static void printBadge(Map<String, Object> benefitInfo) {
        newLine();
        print(Message.TITLE_BADGE.getMessage());
        print((String) benefitInfo.get("badge"));
    }

    public static void printResult(int date, Map<String, Object> benefitInfo) {
        printMenu(date, benefitInfo);
        printTotalPrice(benefitInfo);
        printGift(benefitInfo);
        printBenefitList(benefitInfo);
        printBenefitValue(benefitInfo);
        printPayment(benefitInfo);
        printBadge(benefitInfo);
    }

    public static void print(String text) {
        System.out.println(text);
    }
}