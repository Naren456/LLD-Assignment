package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private int levelNumber;
    private List<ParkingSlot> slots;

    public ParkingLevel(int levelNumber) {
        this.levelNumber = levelNumber;
        this.slots = new ArrayList<>();
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}
