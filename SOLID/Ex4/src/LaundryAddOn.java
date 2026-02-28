
public class LaundryAddOn implements AddOnChoice {
    @Override
    public boolean isSameAddOn(AddOn addOn) {
        return addOn == AddOn.LAUNDRY;
    }

    @Override
    public Money getAddOnPrice() {
        return new Money(1000.0);
    }
}