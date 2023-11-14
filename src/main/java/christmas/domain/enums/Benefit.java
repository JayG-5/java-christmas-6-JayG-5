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

    public static List<BenefitType> getMenuBenefit(int date, int category, int unit) {
        final boolean isWeekend = DateChecker.isWeekend(
                Calendar.PROMOTION_YEAR.getValue(),
                Calendar.PROMOTION_MONTH.getValue(),
                date);
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

    public static List<BenefitType> getPromotionBenefit(List<Integer> stars,int date) {
        final int defaultChristmasBenefit = 10;
        List<BenefitType> benefits = new ArrayList<BenefitType>();
        if (date>=Calendar.CHRISTMAS_EVENT_START.getValue()
                && date<= Calendar.CHRISTMAS_EVENT_END.getValue()){
            for (int i = 0; i <= date+defaultChristmasBenefit; i++) {
                benefits.add(CHRISTMAS.benefit);
            }
        }
        if (stars.contains(date)){
            benefits.add(SPACIAL.benefit);
        }
        return benefits;
    }
}
