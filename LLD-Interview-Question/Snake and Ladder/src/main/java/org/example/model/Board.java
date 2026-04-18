package org.example.model;

import org.example.strategy.GameStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private final Map<Integer, Integer> snakeMap;
    private final Map<Integer, Integer> ladderMap;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.snakeMap = new HashMap<>();
        this.ladderMap = new HashMap<>();

        for (Snake s : snakes) {
            snakeMap.put(s.getStart(), s.getEnd());
        }

        for (Ladder l : ladders) {
            ladderMap.put(l.getStart(), l.getEnd());
        }
    }

    public List<Snake> getSnakes() { return snakes; }
    public List<Ladder> getLadders() { return ladders; }
    public Map<Integer, Integer> getSnakeMap() { return snakeMap; }
    public Map<Integer, Integer> getLadderMap() { return ladderMap; }
    public int getSize() { return size; }

    public int getNewPosition(int currentPos) {
        if (snakeMap.containsKey(currentPos)) {
            System.out.println("  Bitten by a snake at " + currentPos);
            return snakeMap.get(currentPos);
        }
        if (ladderMap.containsKey(currentPos)) {
            System.out.println("  Climbed a ladder at " + currentPos);
            return ladderMap.get(currentPos);
        }
        return currentPos;
    }

    public boolean validatePlacement() {
        int maxPos = size * size;

        for (Snake snake : snakes) {
            int headRow = (snake.getStart() - 1) / size;
            int tailRow = (snake.getEnd() - 1) / size;
            if (headRow == tailRow) return false;
        }

        for (Ladder ladder : ladders) {
            int bottomRow = (ladder.getStart() - 1) / size;
            int topRow = (ladder.getEnd() - 1) / size;
            if (bottomRow == topRow) return false;
        }

        for (int pos : snakeMap.keySet()) {
            if (pos == 1 || pos == maxPos) return false;
            if (ladderMap.containsKey(pos)) return false;
        }
        for (int pos : ladderMap.keySet()) {
            if (pos == 1 || pos == maxPos) return false;
        }

        for (int tailPos : snakeMap.values()) {
            if (ladderMap.containsKey(tailPos)) {
                int ladderEnd = ladderMap.get(tailPos);
                if (snakeMap.containsKey(ladderEnd)) return false;
            }
        }
        return true;
    }
}
