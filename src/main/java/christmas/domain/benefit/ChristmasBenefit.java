package christmas.domain.benefit;

import christmas.domain.enums.Benefit;

public class ChristmasBenefit extends BenefitType {

    public ChristmasBenefit(int value) {
        super(value);
    }

    public static ChristmasBenefit getInstance() {
        return new ChristmasBenefit(Benefit.CHRISTMAS.getValue());
    }
}
