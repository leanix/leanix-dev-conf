package net.leanix.dev.tictactoe;

public class RandomCpuPlayer implements Player {
    public Coordinate submitMove(Board board) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (board.getCellState(coordinate) == 0) {
                    return coordinate;
                }
            }
        }
        throw new RuntimeException("Board is full and no move is possible");
    };
}
