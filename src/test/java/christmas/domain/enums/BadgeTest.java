package christmas.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeTest {

    @Test
    @DisplayName("뱃지 테스트")
    void testFromPrice() {
        assertEquals("없음", Badge.fromPrice(0));
        assertEquals("없음", Badge.fromPrice(4999));
        assertEquals("벌", Badge.fromPrice(5000));
        assertEquals("트리", Badge.fromPrice(10000));
        assertEquals("트리", Badge.fromPrice(15000));
        assertEquals("산타", Badge.fromPrice(20000));
        assertEquals("산타", Badge.fromPrice(25000));
    }
}
