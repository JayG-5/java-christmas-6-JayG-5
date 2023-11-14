package christmas.domain.enums;

import christmas.domain.benefit.*;
import christmas.utils.DateChecker;

import java.util.ArrayList;
import java.util.List;


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

    public static List<BenefitType> getMenuBenefit(int month, int date, int category, int unit) {
        final boolean isWeekend = DateChecker.isWeekend(2023,month,date);
        List<BenefitType> benefits = new ArrayList<BenefitType>();
        if(isWeekend && category == Category.MAIN.getType()){
            for (int i = 0; i <unit ; i++) {
                benefits.add(WEEKEND.benefit);
            }
        }
        if(!isWeekend && category == Category.DESSERT.getType()){
            for (int i = 0; i <unit ; i++) {
                benefits.add(WEEKDAY.benefit);
            }
        }
        return benefits;
    }
}
