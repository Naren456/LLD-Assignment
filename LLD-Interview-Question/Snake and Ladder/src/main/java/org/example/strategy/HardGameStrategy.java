package org.example.strategy;

import org.example.model.Player;

public class HardGameStrategy implements GameStrategy {
    @Override
    public boolean shouldRollAgain(int diceValue) {
        return diceValue == 6;
    }

    @Override
    public boolean isTurnVoid(int consecutiveSixes) {
        return consecutiveSixes >= 3;
    }

    @Override
    public void resetTurn(Player p) {
        p.setCurrentPos(0); // In hard mode, void turn might reset to start
        p.setConsecutiveSixes(0);
    }

    @Override
    public void placeSnakesAndLadders(org.example.model.Board board) {
        // Factory handles placement for this game, but 
        // we implement it to satisfy the interface.
    }
}
