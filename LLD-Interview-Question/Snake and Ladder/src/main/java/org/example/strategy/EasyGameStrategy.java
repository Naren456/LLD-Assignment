package org.example.strategy;

import org.example.model.Board;
import org.example.model.Ladder;
import org.example.model.Player;
import org.example.model.Snake;

import java.util.Random;

public class EasyGameStrategy implements GameStrategy {
    private Random random = new Random();

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
        p.setConsecutiveSixes(0);
    }

    @Override
    public void placeSnakesAndLadders(Board board) {
        int n = board.getSize();
        int totalCells = n * n;

        // Place n random snakes
        for (int i = 0; i < n; i++) {
            int head = random.nextInt(totalCells - 2) + 2; // Head between 2 and total-1
            int tail = random.nextInt(head - 1) + 1;       // Tail < Head
            board.addSnake(new Snake(head, tail));
        }

        // Place n random ladders
        for (int i = 0; i < n; i++) {
            int start = random.nextInt(totalCells - 2) + 2; // Start between 2 and total-1
            int end = random.nextInt(totalCells - start) + start + 1; // End > Start
            
            // Avoid collisions with existing snakes for simplicity in this demo
            if (!board.getSnakeMap().containsKey(start)) {
                board.addLadder(new Ladder(start, end));
            }
        }
    }
}
