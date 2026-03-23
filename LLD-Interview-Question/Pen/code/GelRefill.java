public class GelRefill implements Refill {
    private int inkLevel;

    public GelRefill() {
        this.inkLevel = 100; // Assuming a full refill starts with 100 units of ink
    }

    @Override
    public boolean isEmpty() {
        return inkLevel <= 0;
    }

    @Override
    public void refill() {
        this.inkLevel = 100; // Refill to full capacity
        System.out.println("Gel pen refilled to full capacity.");
    }

    public void setInkLevel(int inkLevel) {
        this.inkLevel = inkLevel;
    }
}
