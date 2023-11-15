package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
