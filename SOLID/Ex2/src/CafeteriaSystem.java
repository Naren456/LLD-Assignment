import java.util.*;

public class CafeteriaSystem {
    private final Menu menu;
    private final InvoiceStore store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(Menu menu, InvoiceStore store) {
        this.menu = menu;
        this.store = store;
    }

    public void checkout(List<OrderLine> lines, TaxCalculator taxCalc, DiscountCalculator discountCalc,
            InvoiceFormatter formatter) {

        String invId = "INV-" + (++invoiceSeq);
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }

        double taxPct = taxCalc.getTaxRate();
        double tax = taxCalc.calculateTax(subtotal);
        double discount = discountCalc.calculateDiscount(subtotal, lines.size());
        double total = subtotal + tax - discount;

        String printable = formatter.format(invId, lines, menu.getItems(), subtotal, taxPct, tax, discount, total);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
