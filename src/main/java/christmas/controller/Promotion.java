package christmas.controller;

import christmas.domain.benefit.BenefitType;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Promotion {

    private final List<Integer> stars;
//    private int date;
//    private List<Menu> menus;
//    private List<BenefitType> benefits;
    private Map<String, Objects> result;

    public Promotion(List<Integer> stars) {
        this.stars = stars;
    }
}
