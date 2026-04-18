package org.example.strategy;

import org.example.model.Ticket;
import java.time.LocalDateTime;

public interface FareStrategy {
    double calculateFare(Ticket ticket, LocalDateTime exitTime);
}
