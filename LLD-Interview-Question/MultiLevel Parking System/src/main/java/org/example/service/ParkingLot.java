package org.example.service;

import org.example.model.*;
import org.example.strategy.FareStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private static ParkingLot instance;
    private ParkingManager parkingManager;
    private FareStrategy fareStrategy;
    private List<Ticket> activeTickets;

    private ParkingLot() {
        this.activeTickets = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void initialize(ParkingManager parkingManager, FareStrategy fareStrategy) {
        this.parkingManager = parkingManager;
        this.fareStrategy = fareStrategy;
    }

    public Ticket park(Vehicle vehicle, LocalDateTime entryTime, SlotType requestedSlotType, Gate entryGate) {
        ParkingSlot slot = parkingManager.findAvailableSlot(vehicle.getType(), requestedSlotType, entryGate);
        if (slot == null) {
            System.out.println("No available slots for vehicle type: " + vehicle.getType());
            return null;
        }

        slot.parkVehicle(vehicle);
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, slot, entryTime);
        activeTickets.add(ticket);
        return ticket;
    }

    public double exit(Ticket ticket, LocalDateTime exitTime) {
        double amount = fareStrategy.calculateFare(ticket, exitTime);
        ticket.getSlot().unparkVehicle();
        activeTickets.remove(ticket);
        return amount;
    }

    public void status() {
        for (ParkingLevel level : parkingManager.getLevels()) {
            System.out.println("Level " + level.getLevelNumber() + ":");
            int small = 0, medium = 0, large = 0;
            for (ParkingSlot slot : level.getSlots()) {
                if (!slot.isOccupied()) {
                    if (slot.getType() == SlotType.SMALL) small++;
                    else if (slot.getType() == SlotType.MEDIUM) medium++;
                    else if (slot.getType() == SlotType.LARGE) large++;
                }
            }
            System.out.println("  Available - Small: " + small + ", Medium: " + medium + ", Large: " + large);
        }
    }
}
