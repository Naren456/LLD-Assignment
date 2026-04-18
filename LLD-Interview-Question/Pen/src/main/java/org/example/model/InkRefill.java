package org.example.model;

public class InkRefill implements Refill {
    private boolean isEmpty;

    public InkRefill() {
        this.isEmpty = false;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void refill() {
        this.isEmpty = false;
        System.out.println("Ink refilled successfully!");
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
}
