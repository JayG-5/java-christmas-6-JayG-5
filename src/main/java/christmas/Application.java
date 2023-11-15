package christmas;

import christmas.controller.Promotion;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        final Promotion promotion = new Promotion(Arrays.asList(3,10,17,24,25,31));
        promotion.order();
    }
}
