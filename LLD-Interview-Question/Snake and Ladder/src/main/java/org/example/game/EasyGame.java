package org.example.game;

import org.example.model.Board;
import org.example.model.Player;
import org.example.strategy.GameStrategy;

public class EasyGame extends Game {

    public EasyGame(int n, int x, Board b, GameStrategy strategy) {
        super(n, x, b, strategy);
    }

    @Override
    public void makeMove() {
        Player currentPlayer = turnOrder.poll();
        if (currentPlayer == null) return;

        boolean rollAgain;
        do {
            rollAgain = false;
            int diceValue = d.roll();
            System.out.println(currentPlayer.getId() + " rolled a " + diceValue);

            if (isValidMove(currentPlayer.getCurrentPos(), diceValue)) {
                int newPos = currentPlayer.getCurrentPos() + diceValue;
                newPos = b.getNewPosition(newPos);
                currentPlayer.setCurrentPos(newPos);

                System.out.println("  " + currentPlayer.getId() + " moved to " + newPos);

                if (checkWinCondition(currentPlayer)) {
                    System.out.println("*** " + currentPlayer.getId() + " wins! ***");
                    activePlayers.remove(currentPlayer);
                    currentPlayer.setConsecutiveSixes(0);
                    return;
                }

                if (strategy.shouldRollAgain(diceValue)) {
                    System.out.println("  " + currentPlayer.getId() + " gets another turn!");
                    rollAgain = true;
                }
            } else {
                System.out.println("  Move not possible. " + currentPlayer.getId() + " stays at " + currentPlayer.getCurrentPos());
            }
        } while (rollAgain);

        currentPlayer.setConsecutiveSixes(0);
        turnOrder.add(currentPlayer);
    }
}
