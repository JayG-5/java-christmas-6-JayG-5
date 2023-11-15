package christmas.domain.benefit;

import christmas.domain.Menu;
import christmas.domain.enums.Benefit;

public class GiftBenefit extends BenefitType {

    private Menu gift;

    public GiftBenefit(String name,int value) {
        super(name,value);
    }

    public static GiftBenefit of(Menu menu) {
        GiftBenefit gift =  new GiftBenefit(Benefit.GIFT.getName(),menu.getPrice());
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
