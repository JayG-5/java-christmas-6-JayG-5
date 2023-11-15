package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.benefit.BenefitType;
import christmas.domain.enums.Badge;
import christmas.domain.enums.Benefit;
import christmas.utils.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.*;

public class Promotion {

    private final List<Integer> stars;
    private Map<String, Objects> result;

    public Promotion(List<Integer> stars) {
        this.stars = stars;
    }

    private Menu createMenu(int date, String orderText) {
        final List<String> order = Parser.splitToList(orderText, "-");
        return new Menu(date, order.get(0), Parser.stringToInt(order.get(1)));
    }

    private Map<String, Object> preprocessBenefitInfo(
            Map<Class<? extends BenefitType>, Map<String, Object>> benefitInfo) {
        Map<String, Object> benefitInfoMap = new HashMap<>();
        Map<String, Object> totalBenefit = new HashMap<>();
        benefitInfo.forEach((k, benefit) -> {
            totalBenefit.put((String) benefit.get("name"), (int) benefit.get("value") * (int) benefit.get("count"));
            if (benefit.containsKey("gift")) benefitInfoMap.put("gift", benefit.get("gift"));
        });
        final int totalBenefitValue =  totalBenefit.values().stream().mapToInt(value -> (int) value).sum();
        benefitInfoMap.put("total_benefit_value",totalBenefitValue);
        benefitInfoMap.put("total_benefit", totalBenefit);
        benefitInfoMap.put("badge", Badge.fromPrice(totalBenefitValue));
        return benefitInfoMap;
    }

    public void order() {
        final int date = InputView.readDate();
        final List<Menu> menus = InputView.readMenu().stream().map(menuText -> createMenu(date, menuText)).toList();
        final int totalPrice = menus.stream().mapToInt(Menu::getPrice).sum();
        List<BenefitType> benefits = Benefit.getPromotionBenefit(stars, date, totalPrice);
        menus.forEach(menu -> benefits.addAll(menu.getBenefits()));
        Map<String, Object> benefitInfo = preprocessBenefitInfo(Benefit.getBenefitInfo(benefits));
        benefitInfo.put("menus",menus);
        benefitInfo.put("total_price",totalPrice);
        OutputView.printResult(date,benefitInfo);
    }
}
