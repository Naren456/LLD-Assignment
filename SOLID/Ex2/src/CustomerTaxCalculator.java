public class CustomerTaxCalculator implements TaxCalculator {
    private final String customerType;

    public CustomerTaxCalculator(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public double calculateTax(double subtotal) {
        double taxPct = TaxRules.taxPercent(customerType);
        return subtotal * (taxPct / 100.0);
    }
}
