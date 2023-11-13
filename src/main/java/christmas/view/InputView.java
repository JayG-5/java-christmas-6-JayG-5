package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.Parser;

public class InputView {
    public int readDate() {
        OutputView.print(Message.REQUEST_DATE.getMessage());
        String input = Console.readLine();
        return Parser.stringToInt(input);
    }

    public  String readMenu(){
        OutputView.print(Message.REQUEST_MENU.getMessage());
        String input = Console.readLine();
        return input;
    }
}