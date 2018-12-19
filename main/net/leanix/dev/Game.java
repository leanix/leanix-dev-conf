package net.leanix.dev;

import java.util.Map.Entry;
import java.util.Random;

public class Game {

    private Player currentPlayer;
    private InputHandler inputHandler;
    private Board board;

    public Game(InputHandler inputHandler, Board board) {
        this.inputHandler = inputHandler;
        this.board = board;
    }

    public void run() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        defineBeginner();
        do{
            next();
            switchPlayer();
        } while (!isFinished());
        printWinner();
    }

    private void printWinner() {

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

    public boolean isFinished() {
        return false;
    }

    private void next() {
        Entry<Integer, Integer> cellCoordinates = inputHandler.handleNextInput(currentPlayer);
        markCell(cellCoordinates);
    }

    private void switchPlayer() {
        switch (currentPlayer){
            case Player_1: currentPlayer = Player.Player_2;
            case Player_2: currentPlayer = Player.Player_1;
        }
    }

    private void markCell(Entry<Integer, Integer> cellCoordinates) {

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
