package net.leanix.dev.tictactoe;

public class RandomCpuPlayer implements Player {
    private final int ownNumber;
    private final ConsoleOutput output;

    public RandomCpuPlayer(int ownNumber, ConsoleOutput output) {
        this.ownNumber = ownNumber;
        this.output = output;
    }

    public Coordinate submitMove(Board board) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (board.getCellState(coordinate) == 0) {
                    output.printMessage("\nPlayer " + ownNumber + " selected " + (char)('A' + x) + y + "\n");
                    return coordinate;
                }
            }
        }
        throw new RuntimeException("Board is full and no move is possible");
    };
}
