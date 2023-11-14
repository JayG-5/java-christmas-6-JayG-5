package christmas.domain.enums;

import christmas.domain.benefit.*;


public enum Benefit {
    CHRISTMAS(ChristmasBenefit.getInstance(),100),
    WEEKDAY(WeekdayBenefit.getInstance(),2023),
    WEEKEND(WeekendBenefit.getInstance(),2023),
    SPACIAL(SpacialBenefit.getInstance(),1000);

    private final BenefitType benefit;
    private final int value;
    Benefit(BenefitType benefit,int value) {
        this.benefit = benefit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
