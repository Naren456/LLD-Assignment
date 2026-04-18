package org.example.strategy;

import java.util.List;

import org.example.model.Gate;
import org.example.model.ParkingLevel;
import org.example.model.ParkingSlot;
import org.example.model.SlotType;
import org.example.model.VehicleType;

public interface ParkingStrategy {
    ParkingSlot findSlot(List<ParkingLevel> levels, VehicleType vehicleType, SlotType requestedSlotType, Gate entryGate);
}
