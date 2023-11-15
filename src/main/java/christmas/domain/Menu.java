package christmas.domain;

import christmas.domain.benefit.BenefitType;
import christmas.domain.enums.Benefit;
import christmas.domain.enums.MenuItem;
import christmas.view.OutputView;

import java.util.List;


public class Menu {
    private final String name;
    private final int price;
    private final int unit;
    private final int category;
    private final List<BenefitType> benefits;

    public Menu(int date, String name, int unit) {
        this.name = name;
        this.unit = unit;

        this.price = MenuItem.getPriceByName(name);
        this.category = MenuItem.getCategoryByName(name);
        this.benefits = Benefit.getMenuBenefit(date, category, unit);
    }

    public void printOrder() {
        OutputView.print(String.format("%s %d개", name, unit));
    }

    public int getPrice() {
        return price * unit;
    }

    public int getCategory() {
        return category;
    }

    public List<BenefitType> getBenefits() {
        return benefits;
    }
}
