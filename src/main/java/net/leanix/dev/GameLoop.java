package net.leanix.dev;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import javafx.util.Pair;

public class GameLoop {
    private BoardConstants currentPlayer;
    private Map<BoardConstants, PlayerStrategy> players = new HashMap<>();

    public void play() {
        Board board = new Board();
        PlayerStrategy playerOne = new HumanPlayerStrategy();
        PlayerStrategy playerTwo = new HumanPlayerStrategy();
        players.put(BoardConstants.PLAYER_ONE, playerOne);
        players.put(BoardConstants.PLAYER_TWO, playerTwo);
        determineStartPlayer();

        while(!(board.determineWinner().isPresent() || board.isFull())) {
            boolean validPositionFound = false;
            while(!validPositionFound) {
                printPlayerPrompt();
                Pair<Integer,Integer> coordinates = players.get(currentPlayer).getNextMove(board);
                if (!board.set(currentPlayer, coordinates.getKey(),coordinates.getValue())) {
                    System.out.println("Position already set");
                } else {
                    validPositionFound = true;
                }
            }
            nextPlayer();
        }

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
