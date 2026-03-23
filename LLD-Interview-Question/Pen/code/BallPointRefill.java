public class BallPointRefill implements Refill {
    private boolean isEmpty;

    public BallPointRefill() {
        this.isEmpty = false;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void refill() {
        this.isEmpty = false;
        System.out.println("Ballpoint pen refilled successfully!");
    }
}