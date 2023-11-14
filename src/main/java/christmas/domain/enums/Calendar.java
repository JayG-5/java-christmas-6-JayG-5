package christmas.domain.enums;

import christmas.domain.benefit.BenefitType;

public enum Calendar {
    PROMOTION_YEAR(2023),
    PROMOTION_MONTH(12),
    CHRISTMAS_EVENT_START(1),
    CHRISTMAS_EVENT_END(25);

    private final int value;
    Calendar(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
