package christmas.domain.benefit;

import christmas.domain.enums.Benefit;

public class SpacialBenefit extends BenefitType {
    public SpacialBenefit(String name,int value) {
        super(name,value);
    }

    public static SpacialBenefit of() {
        return new SpacialBenefit(Benefit.CHRISTMAS.getName(),Benefit.CHRISTMAS.getValue());
    }
}
