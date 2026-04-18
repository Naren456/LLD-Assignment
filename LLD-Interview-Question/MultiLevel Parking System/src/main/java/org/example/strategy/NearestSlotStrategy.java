package org.example.strategy;

import java.util.List;

import org.example.model.Gate;
import org.example.model.ParkingLevel;
import org.example.model.ParkingSlot;
import org.example.model.SlotType;
import org.example.model.VehicleType;

public class NearestSlotStrategy implements ParkingStrategy {

    @Override
    public ParkingSlot findSlot(List<ParkingLevel> levels, VehicleType vehicleType, SlotType requestedSlotType, Gate entryGate) {
        ParkingSlot bestSlot = null;
        int minLevelDiff = Integer.MAX_VALUE;

        // Iterate through all levels to find the one closest to the entry gate
        for (ParkingLevel level : levels) {
            int currentDiff = Math.abs(level.getLevelNumber() - entryGate.getLevelNumber());
            
            // If this level is further than one we already found a slot in, skip level search
            if (currentDiff > minLevelDiff) continue;

            for (ParkingSlot slot : level.getSlots()) {
                if (!slot.isOccupied() && slot.isCompatible(vehicleType)) {
                    // If this level is closer than previous best, or same level but first slot found
                    if (currentDiff < minLevelDiff) {
                        minLevelDiff = currentDiff;
                        bestSlot = slot;
                    }
                    // Break slot loop for this level as we want the first available in the closest level
                    break;
                }
            }
        }
        return bestSlot;
    }
}
