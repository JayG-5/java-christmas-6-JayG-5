package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.PromotionException;
import christmas.utils.Parser;

import java.util.List;
import java.util.function.Function;

public class InputView {
    public static int readDate() {
        return inputHandler(Message.REQUEST_DATE, Parser::stringToInt);
    }

    public static List<String> readMenu(){
        return inputHandler(Message.REQUEST_MENU, input -> {
            return Parser.splitToList(input,",");
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