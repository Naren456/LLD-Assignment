package org.example.strategy;

import org.example.model.Player;

public interface GameStrategy {
    boolean shouldRollAgain(int diceValue);
    boolean isTurnVoid(int consecutiveSixes);
    void resetTurn(Player p);
    void placeSnakesAndLadders(org.example.model.Board board);
}
