package christmas.domain.benefit;

import christmas.domain.Menu;

public class GiftBenefit extends BenefitType {

    private Menu gift;

    public GiftBenefit(int value) {
        super(value);
    }

    public static GiftBenefit of(Menu menu) {
        GiftBenefit gift =  new GiftBenefit(menu.getPrice());
        gift.setGift(menu);
        return gift;
    }

    public void setGift(Menu gift) {
        this.gift = gift;
    }

    public Menu getGift() {
        return gift;
    }
}
