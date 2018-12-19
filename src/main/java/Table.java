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
        for (int column = 0; column < 3; column++) {
            if (isColumnWon(column)) {
                return true;
            }
        }

        return false;
    }

    private boolean isColumnWon(int column) {
        return  table[column][0] == table[column][1] && table[column][1] == table[column][2] && table[column][0] != null;
    }
}
