public class Table {

    private final Player[][] table = new Player[3][3];

    public String draw() {
        return cellContent(0, 2) + "|" + cellContent(1, 2) + "|" + cellContent(2, 2) + "\n"
            + "-+-+-\n"
            + cellContent(0, 1) + "|" + cellContent(1, 1) + "|" + cellContent(2, 1) + "\n"
            + "-+-+-\n"
            + cellContent(0, 0) + "|" + cellContent(1, 0) + "|" + cellContent(2, 0) + "\n";
    }

    private String cellContent(int column, int row) {
        if (table[column][row] == Player.PLAYER_ONE) {
            return "x";
        } else if (table[column][row] == Player.PLAYER_TWO) {
            return "o";
        }
        return " ";
    }

    public boolean insert(Player player, int column, int row) {
        if (table[column][row] != null) {
            return false;
        }

        table[column][row] = player;
        return true;
    }

    public boolean isGameOver() {
        return isColumnWon(0) || isColumnWon(1) || isColumnWon(2)
            || isRowWon(0) || isRowWon(1) || isRowWon(2)
            || isDiagonalWon(true) || isDiagonalWon(false);
    }

    private boolean isColumnWon(int column) {
        int playerOneCount = 0;
        int playerTwoCount = 0;

        for (int row = 0; row < 3; row++) {
            if (table[column][row] == Player.PLAYER_ONE) {
                playerOneCount += 1;
            } else if (table[column][row] == Player.PLAYER_TWO) {
                playerTwoCount += 1;
            }
        }

        return playerOneCount == 3 || playerTwoCount == 3;
    }

    private boolean isRowWon(int row) {
        int playerOneCount = 0;
        int playerTwoCount = 0;

        for (int column = 0; column < 3; column++) {
            if (table[column][row] == Player.PLAYER_ONE) {
                playerOneCount += 1;
            } else if (table[column][row] == Player.PLAYER_TWO) {
                playerTwoCount += 1;
            }
        }

        return playerOneCount == 3 || playerTwoCount == 3;
    }

    private boolean isDiagonalWon() {
        int playerOneCount = 0;
        int playerTwoCount = 0;

        for (int i = 0; i < 3; i++) {
            if (table[i][i] == Player.PLAYER_ONE) {
                playerOneCount += 1;
            } else if (table[i][i] == Player.PLAYER_TWO) {
                playerTwoCount += 1;
            }
        }

        return playerOneCount == 3 || playerTwoCount == 3;
    }

    private boolean isDiagonalWon(boolean topRight) {
        int playerOneCount = 0;
        int playerTwoCount = 0;

        for (int i = 0; i < 3; i++) {
            Player player = topRight ? table[i][i] : table[2 - i][i];

            if (player == Player.PLAYER_ONE) {
                playerOneCount += 1;
            } else if (player == Player.PLAYER_TWO) {
                playerTwoCount += 1;
            }
        }

        return playerOneCount == 3 || playerTwoCount == 3;
    }
}
