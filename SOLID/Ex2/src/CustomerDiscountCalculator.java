public class CustomerDiscountCalculator implements DiscountCalculator {
    private final String customerType;

    public CustomerDiscountCalculator(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public double calculateDiscount(double subtotal, int distinctLines) {
        return DiscountRules.discountAmount(customerType, subtotal, distinctLines);
    }
}
