package christmas.domain.benefit;

import christmas.domain.enums.Benefit;

public class WeekendBenefit extends BenefitType {
    public WeekendBenefit(String name,int value) {
        super(name,value);
    }

    public static WeekendBenefit of() {
        return new WeekendBenefit(Benefit.CHRISTMAS.getName(),Benefit.CHRISTMAS.getValue());
    }
}
