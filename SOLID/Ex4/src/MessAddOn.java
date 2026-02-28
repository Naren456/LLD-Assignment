
public class MessAddOn implements AddOnChoice {
    @Override
    public boolean isSameAddOn(AddOn addOn) {
        return addOn == AddOn.MESS;
    }

    @Override
    public Money getAddOnPrice() {
        return new Money(1000.0);
    }
}