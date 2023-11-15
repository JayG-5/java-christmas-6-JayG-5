package christmas.domain.enums;

import christmas.domain.Menu;
import christmas.domain.benefit.*;
import christmas.utils.Checker;
import christmas.utils.DateChecker;

import java.util.*;


public enum Benefit {
    CHRISTMAS("ChristmasBenefit", "크리스마스 디데이 할인", 100),
    WEEKDAY("WeekdayBenefit", "평일 할인", 2023),
    WEEKEND("WeekendBenefit", "주말 할인", 2023),
    SPACIAL("SpacialBenefit", "특별 할인", 1000),
    GIFT("GiftBenefit", "증정 이벤트", MenuItem.CHAMPAGNE.getPrice());

    private final Menu GIFT_ITEM = MenuItem.CHAMPAGNE.getMenu(1);

    private final String className;
    private final String name;
    private final int value;

    Benefit(String className, String name, int value) {
        this.className = className;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public BenefitType getType(){
        if(Objects.equals(className, "ChristmasBenefit")) return ChristmasBenefit.of();
        else if(Objects.equals(className, "WeekdayBenefit")) return WeekdayBenefit.of();
        else if(Objects.equals(className, "WeekendBenefit")) return WeekendBenefit.of();
        else if(Objects.equals(className, "SpacialBenefit")) return SpacialBenefit.of();
        else if(Objects.equals(className, "GiftBenefit")) return GiftBenefit.of(GIFT_ITEM);
        return null;
    }

    public static List<BenefitType> getMenuBenefit(int date, int category, int unit) {
        final boolean isWeekend = DateChecker.isWeekend(
                Calendar.PROMOTION_YEAR.getValue(), Calendar.PROMOTION_MONTH.getValue(), date);
        List<BenefitType> benefits = new ArrayList<BenefitType>();
        if (isWeekend && category == Category.MAIN.getType()) {
            for (int i = 0; i < unit; i++) {
                benefits.add(WEEKEND.getType());
            }
        }
        if (!isWeekend && category == Category.DESSERT.getType()) {
            for (int i = 0; i < unit; i++) {
                benefits.add(WEEKDAY.getType());
            }
        }
        return benefits;
    }

    public static List<BenefitType> getPromotionBenefit(List<Integer> stars, int date, int totalPrice) {
        final int defaultChristmasBenefit = 10;
        final int giftBenefitPrice = 120000;
        List<BenefitType> benefits = new ArrayList<>();
        if (date >= Calendar.CHRISTMAS_EVENT_START.getValue() && date <= Calendar.CHRISTMAS_EVENT_END.getValue()) {
            for (int i = 1; i < date + defaultChristmasBenefit; i++) {
                benefits.add(CHRISTMAS.getType());
            }
        }
        if (stars.contains(date)) benefits.add(SPACIAL.getType());
        if (totalPrice >= giftBenefitPrice) benefits.add(GIFT.getType());
        return benefits;
    }

    public static Map<Class<? extends BenefitType>, Map<String, Object>>getBenefitInfo(List<BenefitType> benefitTypeList){
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
