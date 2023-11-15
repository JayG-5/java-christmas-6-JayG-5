package christmas.domain.enums;

import christmas.domain.benefit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BenefitTest {
    @Test
    @DisplayName("할인 클래스 테스트")
    void testGetType() {
        assertEquals(ChristmasBenefit.class, Benefit.CHRISTMAS.getType().getClass());
        assertEquals(WeekdayBenefit.class, Benefit.WEEKDAY.getType().getClass());
        assertEquals(WeekendBenefit.class, Benefit.WEEKEND.getType().getClass());
        assertEquals(SpacialBenefit.class, Benefit.SPACIAL.getType().getClass());
        assertEquals(GiftBenefit.class, Benefit.GIFT.getType().getClass());
    }

    @Test
    @DisplayName("할인 이름 테스트")
    void testGetName() {
        assertEquals("크리스마스 디데이 할인", Benefit.CHRISTMAS.getName());
        assertEquals("평일 할인", Benefit.WEEKDAY.getName());
        assertEquals("주말 할인", Benefit.WEEKEND.getName());
        assertEquals("특별 할인", Benefit.SPACIAL.getName());
        assertEquals("증정 이벤트", Benefit.GIFT.getName());
    }

    @Test
    @DisplayName("할인 가격 테스트")
    void testGetValue() {
        assertEquals(100, Benefit.CHRISTMAS.getValue());
        assertEquals(2023, Benefit.WEEKDAY.getValue());
        assertEquals(2023, Benefit.WEEKEND.getValue());
        assertEquals(1000, Benefit.SPACIAL.getValue());
        assertEquals(MenuItem.CHAMPAGNE.getPrice(), Benefit.GIFT.getValue());
    }
}

