package christmas.domain.enums;

import java.util.Arrays;
import java.util.Collections;

public enum Badge {
    STAR("벌",5000),
    TREE("트리",10000),
    SANTA("산타",20000);

    private final String name;
    private final int price;

    Badge(String name,int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public static Badge fromPrice(int amount) {

        Badge[] badges = Badge.values();
        Arrays.sort(badges, Collections.reverseOrder());

        for (Badge badge : badges) {
            if (amount >= badge.price) {
                return badge;
            }
        }
        return null;
    }
}
