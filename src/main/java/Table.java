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

    public void insert(Player player, int column, int row) {
        table[column][row] = player;
    }
}
