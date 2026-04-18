package org.example.model;

import java.time.LocalDateTime;

public class ShowSeat {
    private String id;
    private Show show;
    private Seat seat;
    private SeatStatus seatStatus;
    private double price;
    private LocalDateTime lockedAt;

    public ShowSeat(String id, Show show, Seat seat, double price) {
        this.id = id;
        this.show = show;
        this.seat = seat;
        this.price = price;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public synchronized boolean lock() {
        if (seatStatus == SeatStatus.AVAILABLE) {
            seatStatus = SeatStatus.LOCKED;
            lockedAt = LocalDateTime.now();
            return true;
        }
        // Check if lock expired (e.g., 5 minutes)
        if (seatStatus == SeatStatus.LOCKED && lockedAt.plusMinutes(5).isBefore(LocalDateTime.now())) {
            lockedAt = LocalDateTime.now();
            return true; 
        }
        return false;
    }

    public synchronized void release() {
        if (seatStatus == SeatStatus.LOCKED) {
            seatStatus = SeatStatus.AVAILABLE;
            lockedAt = null;
        }
    }

    public synchronized void book() {
        if (seatStatus == SeatStatus.LOCKED) {
            seatStatus = SeatStatus.BOOKED;
        }
    }

    public String getId() { return id; }
    public Seat getSeat() { return seat; }
    public SeatStatus getSeatStatus() { return seatStatus; }
    public double getPrice() { return price; }
}
