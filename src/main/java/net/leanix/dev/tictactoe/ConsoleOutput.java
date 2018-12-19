package net.leanix.dev.tictactoe;

public class ConsoleOutput {
    public void printBoard(Board board) {
        for (int y = 2; y >= 0; y--) {
            System.out.print(y);
            for (int x = 0; x < 3; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                System.out.print(cellStateToCharacter(board.getCellState(coordinate)));
                if (x < 2) {
                    System.out.print("|");
                } else {
                    System.out.println();
                }
            }
            System.out.println(" -+-+-");
        }
        System.out.println(" A B C");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void prompt(String prompt) {
        System.out.print(prompt);
    }

    private char cellStateToCharacter(int state) {
        return state == 1 ? 'x' :
          state == 2 ? 'o' : ' '; 
    }
}
