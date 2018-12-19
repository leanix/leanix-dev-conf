package net.leanix.dev;

import java.util.Scanner;
import javax.naming.OperationNotSupportedException;

public class HumanPlayer extends BasePlayer implements Player {

    public HumanPlayer(String name, CellState symbol) {
        super(name, symbol);
    }

    @Override
    public void move(Board board) {
        System.out.println("Please insert cell to put a sign (e.g. A1.).");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char column = input.charAt(0);
        int row = Integer.parseInt(String.valueOf(input.charAt(1)));

        try {
            Move move = new Move(column, row);

            if (board.attemptMove(this, move.getX(), move.getY())) {
                System.out.println(getName() + ">" + move.toString());
            } else {
                System.out.println(getName() + "> Your input was invalid. Please try again.");
                move(board);
            }
        } catch (OperationNotSupportedException ex) {
            System.out.println(getName() + "> Your input was invalid. Please try again.");
            move(board);
        }
    }
}
