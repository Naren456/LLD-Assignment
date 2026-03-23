
public abstract class Pen {
    
    private Refill refill;
    private int inkLevel;
    private boolean isReady; 
    private String inkColour;
    private final OpenCloseStrategy strategy;
  
    public Pen(String inkColour, int inkLevel, boolean isOpen, OpenCloseStrategy strategy, Refill refill) {
        this.inkColour = inkColour;
        this.inkLevel = inkLevel;
        this.isReady = isOpen;
        this.strategy = strategy;
        this.refill = refill;
    }
    public void start() {
        if(isReady){
            System.out.println("Pen is already open.");
            return;
        }
        strategy.open();
        isReady = true;
        System.out.println("Pen is ready to write.");
    }

    public void write(String text) {
        if (!isReady) {
            System.out.println("Please start/open the pen before writing.");
        } else if (refill.isEmpty()) {
            System.out.println("Pen is out of ink. Please refill.");
        } else {
            System.out.println("Writing: " + text);
        }
    }

    public void close() {
        strategy.close();
        this.isReady = false;
    }

    public void refill() {
        refill.refill();
    }
}
