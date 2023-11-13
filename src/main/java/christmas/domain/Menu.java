package christmas.domain;

import christmas.domain.enums.MenuItem;

public class Menu {
    private final String name;
    private final int price;
    private final int unit;
    private final int category;

    public Menu(String name, int unit) {
        this.name = name;
        this.unit = unit;

        this.price = MenuItem.getPriceByName(name);
        this.category = MenuItem.getCategoryByName(name);
    }


}
