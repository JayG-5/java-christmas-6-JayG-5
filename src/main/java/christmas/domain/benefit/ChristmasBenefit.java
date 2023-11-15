package christmas.domain.benefit;

import christmas.domain.Menu;
import christmas.domain.enums.Benefit;

public class ChristmasBenefit extends BenefitType {

    public ChristmasBenefit(String name,int value) {
        super(name,value);
    }

    public static ChristmasBenefit of() {
        return new ChristmasBenefit(Benefit.CHRISTMAS.getName(),Benefit.CHRISTMAS.getValue());
    }
}
