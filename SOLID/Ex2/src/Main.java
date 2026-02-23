import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        Menu menu = new Menu();
        menu.add(new MenuItem("M1", "Veg Thali", 80.00));
        menu.add(new MenuItem("C1", "Coffee", 30.00));
        menu.add(new MenuItem("S1", "Sandwich", 60.00));

        InvoiceStore store = new FileStore();
        CafeteriaSystem sys = new CafeteriaSystem(menu, store);

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1));

        TaxCalculator taxCalc = new StudentTaxCalculator();
        DiscountCalculator discountCalc = new StudentDiscountCalculator();
        InvoiceFormatter formatter = new TextInvoiceFormatter();

        sys.checkout(order, taxCalc, discountCalc, formatter);
    }
}
