package org.example;

import org.example.model.*;
import org.example.service.ParkingLot;
import org.example.service.ParkingManager;
import org.example.strategy.HourlyFareStrategy;
import org.example.strategy.NearestSlotStrategy;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Gates on different levels
        Gate gateL0 = new Gate("Entry-L0", 0);
        Gate gateL1 = new Gate("Entry-L1", 1);

        // Initialize Services
        ParkingManager parkingManager = new ParkingManager(new NearestSlotStrategy());
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.initialize(parkingManager, new HourlyFareStrategy());

        // Setup 2 levels
        for (int i = 0; i < 2; i++) {
            ParkingLevel level = new ParkingLevel(i);
            level.addSlot(new ParkingSlot("L" + i + "S1", SlotType.SMALL, i));
            level.addSlot(new ParkingSlot("L" + i + "S2", SlotType.SMALL, i));
            level.addSlot(new ParkingSlot("L" + i + "M1", SlotType.MEDIUM, i));
            level.addSlot(new ParkingSlot("L" + i + "G1", SlotType.LARGE, i));
            parkingManager.addLevel(level);
        }

        System.out.println("--- Initial Status ---");
        parkingLot.status();

        // 1. Park from Level 0
        System.out.println("\nParking Bike (MH-01) from Gate-L0...");
        Ticket t1 = parkingLot.park(new Vehicle("MH-01", VehicleType.TWO_WHEELER), LocalDateTime.now().minusHours(2), SlotType.SMALL, gateL0);
        if (t1 != null) System.out.println("Parked at: " + t1.getSlot().getId());

        // 2. Park from Level 1 (should prioritize Level 1 if available)
        System.out.println("\nParking Bike (KA-05) from Gate-L1...");
        Ticket t2 = parkingLot.park(new Vehicle("KA-05", VehicleType.TWO_WHEELER), LocalDateTime.now().minusHours(1), SlotType.SMALL, gateL1);
        if (t2 != null) System.out.println("Parked at: " + t2.getSlot().getId());

        System.out.println("\n--- Current Status ---");
        parkingLot.status();

        // 3. Billing
        System.out.println("\nProcessing Exit for Bike MH-01 (2 hours)...");
        double bill = parkingLot.exit(t1, LocalDateTime.now());
        System.out.println("Bill: $" + bill + " (Expected $20.0)");

        System.out.println("\n--- Final Status ---");
        parkingLot.status();
    }
}
