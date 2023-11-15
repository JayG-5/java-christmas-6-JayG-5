package christmas.utils;

import christmas.exception.Message;
import christmas.exception.PromotionException;

public class Checker {
    public static void isBetween1And31(int number) {
        if (number < 1 || number > 31) {
            throw PromotionException.of(Message.NUMBER);
        }
    }
}
