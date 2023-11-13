package christmas.domain.enums;

public enum Category {
    APPETIZER(0,"에피타이저"),
    MAIN(1,"메인"),
    DESSERT(2,"디저트"),
    BEVERAGE(3,"음료");

    private final int type;
    private final String name;

    Category(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
