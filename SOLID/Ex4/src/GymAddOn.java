
public class GymAddOn implements AddOnChoice {
    @Override
    public boolean isSameAddOn(AddOn addOn) {
        return addOn == AddOn.GYM;
    }

    @Override
    public Money getAddOnPrice() {
        return new Money(1000.0);
    }
}