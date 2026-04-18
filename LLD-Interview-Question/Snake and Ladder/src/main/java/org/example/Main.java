package org.example;

import org.example.factory.GameFactory;
import org.example.game.Game;
import org.example.model.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Welcome to Snake and Ladder ---");
        
        System.out.print("Enter Board Size (N for NxN): ");
        int n = scanner.hasNextInt() ? scanner.nextInt() : 10;
        
        System.out.print("Enter Number of Players: ");
        int x = scanner.hasNextInt() ? scanner.nextInt() : 2;
        
        System.out.print("Enter Difficulty Level (easy/hard): ");
        String difficulty = scanner.hasNext() ? scanner.next() : "easy";

        Game game = GameFactory.getGame(n, x, difficulty);

        for (int i = 1; i <= x; i++) {
            game.addPlayer(new Player("Player-" + i));
        }

        game.startGame();
        
        scanner.close();
    }
}
