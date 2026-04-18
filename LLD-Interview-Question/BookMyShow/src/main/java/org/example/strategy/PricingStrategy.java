package org.example.strategy;

import org.example.model.SeatCategory;
import org.example.model.Show;

public interface PricingStrategy {
    double calculatePrice(Show show, SeatCategory category);
}
