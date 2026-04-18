package org.example.model;

public class Seat {
    private String id;
    private int row;
    private int col;
    private SeatCategory seatCategory;

    public Seat(String id, int row, int col, SeatCategory seatCategory) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.seatCategory = seatCategory;
    }

    public String getId() { return id; }
    public SeatCategory getSeatCategory() { return seatCategory; }
}
