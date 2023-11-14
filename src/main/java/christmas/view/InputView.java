package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.Parser;

import java.util.List;

public class InputView {
    public static int readDate() {
        OutputView.print(Message.REQUEST_DATE.getMessage());
        String input = Console.readLine();
        return Parser.stringToInt(input);
    }

    public static List<String> readMenu(){
        OutputView.print(Message.REQUEST_MENU.getMessage());
        String input = Console.readLine();
        return Parser.splitToList(input,",");
    }
}