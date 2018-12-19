public class Table {

    private final Player[][] table = new Player[3][3];

    public Table() {
    }


    public String draw() {
        return celContent(0, 0) + "|" + celContent(1, 0) + "|" + celContent(2, 0) + "\n"
            + "-+-+-\n"
            + celContent(0, 1) + "|" + celContent(1, 1) + "|" + celContent(2, 1) + "\n"
            + "-+-+-\n"
            + celContent(0, 2) + "|" + celContent(1, 2) + "|" + celContent(2, 2) + "\n";
    }

    private String celContent(int column, int row) {
        if (table[column][row] == Player.PLAYER_ONE) {
            return "x";
        } else if (table[column][row] == Player.PLAYER_TWO) {
            return "o";
        }
        return " ";
    }

    public void insert(Player player, int colomn, int row) {
        table[colomn][row] = player;
    }
}
