package net.leanix.dev;

import java.util.Optional;
import java.util.Scanner;
import javafx.util.Pair;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Pair<Integer, Integer> getNextMove(ReadOnlyBoard board) {
        boolean gotResult = false;
        Pair<Integer, Integer> result = null;
        while (!gotResult) {
            String line = scanner.nextLine(); // input structure: letter|number

            Optional<Pair<Integer, Integer>> decodedResult = decode(line);
            if (!decodedResult.isPresent()) continue;

            result = decodedResult.get();
            gotResult = true;
        }
        return result;
    }

    static Optional<Pair<Integer, Integer>> decode(String line) {
        if (line.length() != 2) {
            System.out.println("Invalid position.");
            return Optional.empty();
        }

        char colChar = line.charAt(0);
        char rowChar = line.charAt(1);

        int col = -1;
        switch (colChar) {
            case 'a':
                col = 0;
                break;
            case 'b':
                col = 1;
                break;
            case 'c':
                col = 2;
                break;
            default:
                System.out.println("Invalid position.");
                return Optional.empty();
        }

        int row = Character.getNumericValue(rowChar);
        if (row > 2) {
            System.out.println("Invalid position.");
            return Optional.empty();
        }
        return Optional.of(new Pair<>(row, col));
    }
}
