package java.net.leanix.dev;

import java.util.Scanner;

public class InputHandler {

    Scanner inputScanner = new Scanner(System.in);


    public void handleNextInput(String player) {
        System.out.println(player + "s turn" );
        String input = inputScanner.next();
        if (input.length() != 2) {
            input = handleInvalidInput();
        }
        String column = input.substring(0, 1);
        String row = input.substring(1, 1);
        if (inputIsInvalid(column, row)){

        }
    }

    private boolean inputIsInvalid(String column, String row) {
        return false;
    }

    private String handleInvalidInput() {
        System.out.println("Invalid move, try again");
        return inputScanner.next();
    }

}
