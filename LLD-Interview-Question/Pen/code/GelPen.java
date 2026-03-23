
public class GelPen extends Pen{
     public GelPen(String type, String color, int inkLevel, boolean isRefillable, OpenCloseStrategy openCloseStrategy, Refill refill) {
        super(color, inkLevel, false, openCloseStrategy, refill);
    }
}