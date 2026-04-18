package org.example.model;

import org.example.strategy.OpenCloseStrategy;

public class GelPen extends Pen {
    public GelPen(String inkColour, int inkLevel, boolean isOpen, OpenCloseStrategy strategy, Refill refill) {
        super(inkColour, inkLevel, isOpen, strategy, refill);
    }
}
