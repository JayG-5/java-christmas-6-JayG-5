package christmas.domain.benefit;

public abstract class BenefitType {
    private final String name;
    private final int value;

    public BenefitType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

