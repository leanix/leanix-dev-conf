package net.leanix.dev.tictactoe;

import java.util.Optional;

import javafx.util.Pair;
import net.leanix.dev.tictactoe.GameLogic.GameState;

public class AlternativeCpuPlayer implements Player {
    private final int ownNumber; // 1 or 2
    private final GameLogic gameLogic = new GameLogic();
    private final ConsoleOutput output;

    public AlternativeCpuPlayer(int ownNumber, ConsoleOutput output) {
        this.ownNumber = ownNumber;
        this.output = output;
    }

    public Coordinate submitMove(Board board) {
        Coordinate move = findBestMove(board, ownNumber).getKey();
        output.printMessage("\nPlayer " + ownNumber + " selected " + (char)('A' + move.getX()) + move.getY() + "\n");
        return move;
    }

    private Pair<Coordinate, Integer> findBestMove(Board board, int playerNumber) {
        Pair<Coordinate, Integer> bestMove = null;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Coordinate move = new Coordinate(x, y);
                if (board.getCellState(move) == 0) {
                    board.setCellState(move, playerNumber);
                    switch (gameLogic.getGameState(board)) {
                        case WIN_PLAYER_1:
                        case WIN_PLAYER_2:
                            // Must be a win for the given player
                            board.setCellState(move, 0);                            
                            return new Pair(move, playerNumber);
                        case DRAW:
                            // Only possible move, but it leads to a draw
                            board.setCellState(move, 0);
                            return new Pair(move, 0);
                        default:
                            Pair<Coordinate, Integer> bestNextMoveForOpponent = findBestMove(board, 3 - playerNumber);
                            if (bestMove == null ||
                                bestNextMoveForOpponent.getValue() == playerNumber ||
                                bestNextMoveForOpponent.getValue() == 0 && bestMove.getValue() != playerNumber
                            ) {
                                bestMove = new Pair(move, bestNextMoveForOpponent.getValue());
                            }
                            board.setCellState(move, 0);
                    }
                }
            }
        }
        return bestMove;
    }
}
