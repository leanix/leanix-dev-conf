package net.leanix.dev;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import javafx.util.Pair;

public class GameLoop {
    private Board board;
    private BoardConstants currentPlayer;
    private Map<BoardConstants, PlayerStrategy> players = new HashMap<>();

    GameLoop() {
        board = new Board();
    }

    public void init(PlayerStrategy playerOne, PlayerStrategy playerTwo) {
        players.put(BoardConstants.PLAYER_ONE, playerOne);
        players.put(BoardConstants.PLAYER_TWO, playerTwo);
    }

    public void play() {
        determineStartPlayer();

        while(!(board.determineWinner().isPresent() || board.isFull())) {
            System.out.println(board.toString());
            boolean validPositionFound = false;
            while(!validPositionFound) {
                printPlayerPrompt();
                Pair<Integer,Integer> coordinates = players.get(currentPlayer).getNextMove(board);
                System.out.print("\n");

                if (!board.set(currentPlayer, coordinates.getKey(),coordinates.getValue())) {
                    System.out.println("Position already set");
                } else {
                    validPositionFound = true;
                }
            }
            nextPlayer();
        }

        System.out.println(board.toString());

        Optional<BoardConstants> winner = board.determineWinner();
        if (winner.isPresent()) {
            winner.ifPresent(player -> {
                System.out.println(player + " has won!");
            });
        } else {
            System.out.println("Draw");
        }
        System.out.println("Thanks for playing!");
    }

    private void determineStartPlayer() {
        int val = new Random().nextInt(1);
        if(val == 0) {
            currentPlayer = BoardConstants.PLAYER_ONE;
        } else {
            currentPlayer = BoardConstants.PLAYER_TWO;
        }
    }

    private void nextPlayer() {
        if (currentPlayer == BoardConstants.PLAYER_ONE) {
            currentPlayer = BoardConstants.PLAYER_TWO;
        } else {
            currentPlayer = BoardConstants.PLAYER_ONE;
        }
    }

    private void printPlayerPrompt() {
        if (currentPlayer == BoardConstants.PLAYER_ONE) {
            System.out.print("Player 1>");
        } else {
            System.out.print("Player 2>");
        }
    }
}
