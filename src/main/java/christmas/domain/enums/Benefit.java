package christmas.domain.enums;

import christmas.domain.benefit.*;
import christmas.utils.DateChecker;

import java.util.*;


public enum Benefit {
    CHRISTMAS(ChristmasBenefit.of(), "크리스마스 디데이 할인", 100),
    WEEKDAY(WeekdayBenefit.of(), "평일 할인", 2023),
    WEEKEND(WeekendBenefit.of(), "주말 할인", 2023),
    SPACIAL(SpacialBenefit.of(), "특별 할인", 1000),
    GIFT(GiftBenefit.of(MenuItem.CHAMPAGNE.getMenu(1)), "증정 이벤트", MenuItem.CHAMPAGNE.getPrice());

    private final BenefitType benefit;
    private final String name;
    private final int value;

    Benefit(BenefitType benefit, String name, int value) {
        this.benefit = benefit;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static List<BenefitType> getMenuBenefit(int date, int category, int unit) {
        final boolean isWeekend = DateChecker.isWeekend(
                Calendar.PROMOTION_YEAR.getValue(), Calendar.PROMOTION_MONTH.getValue(), date);
        List<BenefitType> benefits = new ArrayList<BenefitType>();
        if (isWeekend && category == Category.MAIN.getType()) {
            for (int i = 0; i < unit; i++) {
                benefits.add(WEEKEND.benefit);
            }
        }
        if (!isWeekend && category == Category.DESSERT.getType()) {
            for (int i = 0; i < unit; i++) {
                benefits.add(WEEKDAY.benefit);
            }
        }
        return benefits;
    }

    public static List<BenefitType> getPromotionBenefit(List<Integer> stars, int date, int totalPrice) {
        final int defaultChristmasBenefit = 10;
        final int giftBenefitPrice = 120000;
        List<BenefitType> benefits = new ArrayList<>();
        if (date >= Calendar.CHRISTMAS_EVENT_START.getValue() && date <= Calendar.CHRISTMAS_EVENT_END.getValue()) {
            for (int i = 0; i <= date + defaultChristmasBenefit; i++) {
                benefits.add(CHRISTMAS.benefit);
            }
        }
        if (stars.contains(date)) benefits.add(SPACIAL.benefit);
        if (totalPrice >= giftBenefitPrice) benefits.add(GIFT.benefit);
        return benefits;
    }

    public static Map<Class<? extends BenefitType>, Map<String, Object>> getBenefitInfo(List<BenefitType> benefitTypeList){
        Map<Class<? extends BenefitType>, Map<String, Object>> benefitInfoMap = new HashMap<>();
        for (BenefitType benefit : benefitTypeList) {
            Class<? extends BenefitType> benefitType = benefit.getClass();
            Map<String, Object> classMap = benefitInfoMap.computeIfAbsent(benefitType, i -> new HashMap<>());
            int count = (int) classMap.getOrDefault("count", 0);
            classMap.put("name", benefit.getName());
            classMap.put("value", benefit.getValue());
            classMap.put("count", count + 1);
            if (benefit instanceof GiftBenefit giftBenefit) {
                classMap.put("gift", giftBenefit.getGift());
            }
        }
        return benefitInfoMap;
    }
}
