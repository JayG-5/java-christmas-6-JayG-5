package christmas.domain.benefit;

import christmas.domain.enums.Benefit;

public class WeekdayBenefit extends BenefitType {

    public WeekdayBenefit(int value) {
        super(value);
    }

    public static WeekdayBenefit getInstance() {
        return new WeekdayBenefit(Benefit.WEEKDAY.getValue());
    }
}
