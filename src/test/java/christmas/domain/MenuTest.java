package christmas.domain;

import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.WeekdayBenefit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MenuTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        int date = 25;
        String name = "초코케이크";
        int unit = 3;
        menu = new Menu(date, name, unit);
    }

    @Test
    @DisplayName("메뉴 가격 검사")
    void testGetPrice() {
        int expectedPrice = 15000 * 3;
        assertEquals(expectedPrice, menu.getPrice());
    }

    @Test
    @DisplayName("메뉴 갯수 검사")
    void testGetUnit() {
        int expectedUnit = 3;
        assertEquals(expectedUnit, menu.getUnit());
    }

    @Test
    @DisplayName("메뉴 카테고리 검사")
    void testGetCategory() {
        int expectedCategory = 2;
        assertEquals(expectedCategory, menu.getCategory());
    }

    @Test
    @DisplayName("메뉴 할인 검사")
    void testGetBenefits() {
        List<BenefitType> benefits = menu.getBenefits();
        long weekdayBenefitCount = benefits.stream()
                .filter(benefit -> benefit instanceof WeekdayBenefit)
                .count();

        assertEquals(3, weekdayBenefitCount);
        assertEquals(3, benefits.size());
    }

    @Test
    @DisplayName("메뉴 출력 검사")
    void testPrintOrder() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        boolean calledPrint = false;
        menu.printOrder();
        String expectedOutput = "초코케이크 3개\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
        System.setOut(System.out);
    }
}
