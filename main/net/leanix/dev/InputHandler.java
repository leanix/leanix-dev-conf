package net.leanix.dev;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import net.leanix.dev.Game.Player;


public class InputHandler {

    private Scanner inputScanner;
    private Board board;
    public static final List<String> COLUMN_MAPPING = Arrays.asList("a","b","c");

    public InputHandler(Board board) {
        this.inputScanner = new Scanner(System.in);
        this.board = board;
    }


    public Entry<Integer, Integer> handleNextInput(Player player) {
            System.out.println(player + "s turn");
            String input = inputScanner.next();
            if (inputIsInvalid(input)) {
                input = handleInvalidInput();
            }
            return splitInputString(input);

    }

    static Entry<Integer, Integer> splitInputString(String input) {
        String stringColumn = input.substring(0, 1);
        int column = COLUMN_MAPPING.indexOf(stringColumn);
        int row = Integer.parseInt(input.substring(1));
        return new AbstractMap.SimpleImmutableEntry<>(column, row);
    }

    boolean inputIsInvalid(String input) {
        if(input == null || input.isEmpty()){
            return true;
        }
        boolean matches = input.matches("^[abc][012]$");
        if(!matches) {
            //invalid String format
            return true;
        }
        Entry<Integer, Integer> cellCoordinates = splitInputString(input);
        boolean empty = board.isEmpty(cellCoordinates.getKey(), cellCoordinates.getValue());
        return !empty;
    }

    private String handleInvalidInput() {
        String input;
        do{
            System.out.println("Invalid move, try again");
            input = inputScanner.next();
        }while (inputIsInvalid(input));
        return input;
    }

}
