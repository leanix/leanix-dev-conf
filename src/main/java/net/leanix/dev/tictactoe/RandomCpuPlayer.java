package net.leanix.dev.tictactoe;

import java.util.Random;

public class RandomCpuPlayer implements Player {
    private final int ownNumber;
    private final ConsoleOutput output;

    public RandomCpuPlayer(int ownNumber, ConsoleOutput output) {
        this.ownNumber = ownNumber;
        this.output = output;
    }

    public Coordinate submitMove(Board board) {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int x = rand.nextInt(3);
            int y = rand.nextInt(3);
            Coordinate coordinate = new Coordinate(x, y);
            if (board.getCellState(coordinate) == 0) {
                output.printMessage("\nPlayer " + ownNumber + " selected " + (char) ('A' + x) + y + "\n");
                return coordinate;
            }
        }
        throw new RuntimeException("Unable to find a random field that is selectable. is the board full?");
    };
}
