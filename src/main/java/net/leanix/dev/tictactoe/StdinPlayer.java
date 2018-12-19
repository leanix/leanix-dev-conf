package net.leanix.dev.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class StdinPlayer implements Player {
    private final int ownNumber;
    private final ConsoleOutput output;

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @param number code that can be compared to game cell state (1 or 2)
     * @param output
     */
    public StdinPlayer(int number, ConsoleOutput output) {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException("invalid player number " + number);
        }

        ownNumber = number;
        this.output = output;
    }

    @Override
    public Coordinate submitMove(Board board) {
        Optional<Coordinate> coordinate = Optional.empty();
        while (!coordinate.isPresent()) {
            output.prompt("\nPlayer " + ownNumber + '>');
            String in = null;
            try {
                in = reader.readLine();
                coordinate = parseCoordinate(in);
            } catch (IOException e) {
                output.printMessage("Something system bug has happened. Try entering again.");
            }
        }
        return coordinate.get();
    }

    public Optional<Coordinate> parseCoordinate(String input) {
        if (input.length() != 2) {
            output.printMessage("Input needs to be 2 characters. Please enter correct move.");
            return Optional.empty();
        }

        int x;
        char xc = input.charAt(0);
        switch (Character.toLowerCase(xc)) {
            case 'a':
                x = 0;
                break;
            case 'b':
                x = 1;
                break;
            case 'c':
                x = 2;
                break;
            default:
                output.printMessage("First coordinate needs to be A, B, or C. Please enter correct move.");
                return Optional.empty();
        }

        int y;
        char yc = input.charAt(1);
        switch (yc) {
            case '0':
                y = 0;
                break;
            case '1':
                y = 1;
                break;
            case '2':
                y = 2;
                break;
            default:
                output.printMessage("Second coordinate needs to be 0, 1, or 2. Please enter correct move.");
                return Optional.empty();
        }

        return Optional.of(new Coordinate(x, y));
    }
}
