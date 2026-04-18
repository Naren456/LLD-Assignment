package org.example.service;

import org.example.model.*;
import org.example.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    private List<ParkingLevel> levels;
    private ParkingStrategy parkingStrategy;

    public ParkingManager(ParkingStrategy parkingStrategy) {
        this.levels = new ArrayList<>();
        this.parkingStrategy = parkingStrategy;
    }

    public void addLevel(ParkingLevel level) {
        levels.add(level);
    }

    public ParkingSlot findAvailableSlot(VehicleType vehicleType, SlotType requestedSlotType, Gate entryGate) {
        return parkingStrategy.findSlot(levels, vehicleType, requestedSlotType, entryGate);
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public List<ParkingLevel> getLevels() {
        return levels;
    }
}
