package christmas.controller;

import christmas.domain.Menu;
import christmas.exception.PromotionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PromotionTest {



    @Test
    @DisplayName("메뉴 생성 검사")
    void testCreateMenuWithValidInput() {
        int date = 25;
        String orderText = "타파스-3";
        Menu menu = Promotion.createMenu(date, orderText);
        assertEquals("타파스", menu.getName());
        assertEquals(3, menu.getUnit());
    }

    @Test
    @DisplayName("메뉴 오류 검사")
    void testCreateMenuWithInvalidInput() {
        int date = 25;
        String orderText = "타타타타파스-1";
        assertThrows(PromotionException.class, () -> Promotion.createMenu(date, orderText));
    }
}

