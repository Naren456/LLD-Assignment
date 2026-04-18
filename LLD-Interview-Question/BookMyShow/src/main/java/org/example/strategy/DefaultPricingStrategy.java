package org.example.strategy;

import org.example.model.SeatCategory;
import org.example.model.Show;
import java.time.LocalTime;

public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Show show, SeatCategory category) {
        double basePrice = 100;
        
        // Category based pricing
        switch (category) {
            case SILVER: basePrice = 150; break;
            case GOLD: basePrice = 250; break;
            case PLATINUM: basePrice = 400; break;
        }

        // Time based surge (e.g., evening shows)
        if (show.getStartTime().toLocalTime().isAfter(LocalTime.of(18, 0))) {
            basePrice *= 1.2;
        }

        return basePrice;
    }
}
