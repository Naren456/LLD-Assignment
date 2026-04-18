package org.example.strategy;

import org.example.model.Ticket;
import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(Ticket ticket, LocalDateTime exitTime) {
        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        long hours = (long) Math.ceil(duration.toMinutes() / 60.0);
        if (hours <= 0) hours = 1; // Minimum 1 hour charge
        
        return hours * ticket.getSlot().getType().getHourlyRate();
    }
}
