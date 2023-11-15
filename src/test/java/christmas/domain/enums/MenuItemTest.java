package christmas.domain.enums;

import christmas.exception.PromotionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuItemTest {

    @Test
    @DisplayName("메뉴 가격 검사")
    void testGetPriceByName() {
        assertEquals(6000, MenuItem.getPriceByName("양송이수프"));
        assertEquals(5500, MenuItem.getPriceByName("타파스"));
        assertEquals(8000, MenuItem.getPriceByName("시저샐러드"));
    }

    @Test
    @DisplayName("메뉴 카테고리 검사")
    void testGetCategoryByName() {
        assertEquals(Category.APPETIZER.getType(), MenuItem.getCategoryByName("양송이수프"));
        assertEquals(Category.APPETIZER.getType(), MenuItem.getCategoryByName("타파스"));
        assertEquals(Category.APPETIZER.getType(), MenuItem.getCategoryByName("시저샐러드"));
    }

    @Test
    @DisplayName("메뉴 가격 검사 예외처리")
    void testGetPriceByNameWithInvalidName() {
        assertThrows(PromotionException.class, () -> MenuItem.getPriceByName("바닐라쉐이크"));
    }

    @Test
    @DisplayName("메뉴 카테고리 검사 예외처리")
    void testGetCategoryByNameWithInvalidName() {
        assertThrows(PromotionException.class, () -> MenuItem.getCategoryByName("InvalidMenuName"));
    }
}
