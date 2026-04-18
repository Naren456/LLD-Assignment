package org.example.model;

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
        System.out.println("Ball point refill changed successfully!");
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
}
