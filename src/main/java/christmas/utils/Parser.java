package christmas.utils;

import christmas.exception.Message;
import christmas.exception.PromotionException;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static void validateWhiteSpace(String text) {
        if (text.chars().anyMatch(Character::isWhitespace)) {
            throw PromotionException.of(Message.INPUT);
        }
    }

    public static int stringToInt(String text) {
        validateWhiteSpace(text);
        return Integer.parseInt(text);
    }

    public static List<String> splitToList(String text, String regex) {
        return Arrays.stream(text.split(regex)).toList();
    }
}
