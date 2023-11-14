package christmas.domain.benefit;

import christmas.domain.enums.Benefit;

public class WeekendBenefit extends BenefitType {
    public WeekendBenefit(int value) {
        super(value);
    }

    public static WeekendBenefit getInstance() {
        return new WeekendBenefit(Benefit.WEEKEND.getValue());
    }
}
