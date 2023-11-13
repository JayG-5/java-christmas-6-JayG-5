package christmas.utils;

public class Parser {

    private static void validateWhiteSpace(String text){
        if (text.chars().anyMatch(Character::isWhitespace)){
            //예외 처리
        }
    }
    public static int stringToInt(String text){
        try{
            validateWhiteSpace(text);
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            //예외 처리
        }
    }
}
