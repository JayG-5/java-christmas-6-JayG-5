package christmas.domain.benefit;

import christmas.domain.enums.Benefit;

public class WeekdayBenefit extends BenefitType {
    public WeekdayBenefit(String name,int value) {
        super(name,value);
    }

    public static WeekdayBenefit of() {
        return new WeekdayBenefit(Benefit.WEEKDAY.getName(),Benefit.WEEKDAY.getValue());
    }
}
