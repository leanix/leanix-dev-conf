package net.leanix.dev;

import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import net.leanix.dev.Board.FinishedState;

public class Game {

    private Player currentPlayer;
    private InputHandler inputHandler;
    private Board board;
    private Set<Player> computerPlayer;

    public Game(Set<Player> computerPlayer) {
        Board board = new Board();
        this.inputHandler = new InputHandler(board);
        this.computerPlayer = computerPlayer;
        this.board = board;
    }

    public void run() {
        Optional<FinishedState> finishedState;
        System.out.println("Welcome to Tic-Tac-Toe!");
        defineBeginner();
        do{
            next();
            switchPlayer();
            System.out.println(board.toString());
            finishedState = board.isFinished();
        } while (!finishedState.isPresent());
        printWinner(finishedState.get());
    }

    private void printWinner(FinishedState finishedState) {
        if(finishedState.isDraw()){
            System.out.println("Draw round.");
        }else{
            switch (finishedState.getWinningSign()){
                case CROSS:
                    System.out.println("Player 1 wins.");
                    break;
                case CIRCLE:
                    System.out.println("Player 2 wins.");
                    break;
            }
        }

    }

    private void defineBeginner() {
        int diceResult = roleDices();
        if(diceResult <= 50) {
            currentPlayer = Player.Player_1;
        } else {
            currentPlayer = Player.Player_2;
        }
        System.out.println(currentPlayer.toString() + " begins");
    }

    private void next() {
        System.out.println(currentPlayer + "'s turn");
        Entry<Integer, Integer> cellCoordinates;
        if(computerPlayer.contains(currentPlayer)){
            do{
                cellCoordinates = CPU.chooseCellCoordinates();
            }while(board.isEmpty(cellCoordinates.getValue(), cellCoordinates.getKey()));
        }else {
            cellCoordinates = inputHandler.handleNextInput();
        }
        markCell(cellCoordinates);
    }

    private void switchPlayer() {
        switch (currentPlayer){
            case Player_1: currentPlayer = Player.Player_2; break;
            case Player_2: currentPlayer = Player.Player_1; break;
        }
    }

    private void markCell(Entry<Integer, Integer> cellCoordinates) {
        switch (currentPlayer) {
            case Player_1: board.setCell(cellCoordinates.getValue(), cellCoordinates.getKey(), Cell.CROSS);break;
            case Player_2: board.setCell(cellCoordinates.getValue(), cellCoordinates.getKey(), Cell.CIRCLE);break;
        }
    }

    enum Player {
        Player_1,
        Player_2
    }

    private static int roleDices() {
        Random r = new Random();
        int low = 1;
        int high = 100;
        return r.nextInt(high-low) + low;

    }
}
