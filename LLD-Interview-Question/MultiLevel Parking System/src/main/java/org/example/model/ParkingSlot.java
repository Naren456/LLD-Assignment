package org.example.model;

public class ParkingSlot {
    private String id;
    private SlotType type;
    private boolean isOccupied;
    private int levelNumber;
    private Vehicle parkedVehicle;

    public ParkingSlot(String id, SlotType type, int levelNumber) {
        this.id = id;
        this.type = type;
        this.levelNumber = levelNumber;
        this.isOccupied = false;
    }

    public String getId() {
        return id;
    }

    public SlotType getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public void unparkVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isCompatible(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEELER:
                return true; // Can park in Small, Medium, Large
            case CAR:
                return type == SlotType.MEDIUM || type == SlotType.LARGE;
            case BUS:
                return type == SlotType.LARGE;
            default:
                return false;
        }
    }
}
