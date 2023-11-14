package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.benefit.BenefitType;
import christmas.utils.Parser;
import christmas.view.InputView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Promotion {

    private final List<Integer> stars;
//    private List<BenefitType> benefits;
    private Map<String, Objects> result;

    public Promotion(List<Integer> stars) {
        this.stars = stars;
    }

    private Menu createMenu(int date, String orderText) {
        final List<String> order = Parser.splitToList(orderText, "-");
        return new Menu(date, order.get(0), Parser.stringToInt(order.get(1)));
    }

    public void order() {
        final int date = InputView.readDate();
        final List<Menu> menus = InputView.readMenu().stream().map(menuText -> createMenu(date, menuText)).toList();
        menus.stream().mapToInt(Menu::getPrice).sum();


    }
}
