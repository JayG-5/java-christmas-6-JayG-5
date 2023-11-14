package christmas.domain.benefit;

import christmas.domain.enums.Benefit;

public class SpacialBenefit extends BenefitType {
    public SpacialBenefit(int value) {
        super(value);
    }

    public static SpacialBenefit getInstance() {
        return new SpacialBenefit(Benefit.SPACIAL.getValue());
    }
}
