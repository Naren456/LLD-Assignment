package org.example.model;

import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<ShowSeat> bookedSeats;
    private double totalAmount;
    private BookingStatus status;

    public Booking(String id, User user, Show show, List<ShowSeat> bookedSeats) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.totalAmount = bookedSeats.stream().mapToDouble(ShowSeat::getPrice).sum();
        this.status = BookingStatus.PENDING;
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
        bookedSeats.forEach(ShowSeat::book);
    }

    public void cancel() {
        this.status = BookingStatus.CANCELLED;
        bookedSeats.forEach(ShowSeat::release);
    }

    public String getId() { return id; }
    public BookingStatus getStatus() { return status; }
    public double getTotalAmount() { return totalAmount; }
}
