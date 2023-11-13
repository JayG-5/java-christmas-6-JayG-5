package christmas.utils;

import christmas.exception.Message;
import christmas.exception.PromotionException;

public class Parser {

    private static void validateWhiteSpace(String text){
        if (text.chars().anyMatch(Character::isWhitespace)){
            throw PromotionException.of(Message.INPUT);
        }
    }
    public static int stringToInt(String text){
        try{
            validateWhiteSpace(text);
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            throw PromotionException.of(Message.NUMBER);
        }
    }
}
