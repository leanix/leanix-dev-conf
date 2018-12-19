public class Game {

    private final Table table;
    private GameState state;

    public Game(Table table, Player startingPlayer) {
        this.table = table;
        this.state = new GameState(startingPlayer, Message.ENTER_COMMAND);
    }

    public GameState getState() {
        return state;
    }

    public void runCommand(String command) {
        try {
            Coordinate coordinate = Parser.parse(command);
            boolean insertSuccessful = table.insert(state.player, coordinate.column, coordinate.row);
            state = nextState(insertSuccessful);
        } catch(IllegalArgumentException e) {
            state = new GameState(state.player, Message.INVALID_COMMAND);
        }
    }

    private GameState nextState(boolean insertSuccessful) {
        if (!insertSuccessful) {
            return new GameState(state.player, Message.CELL_NOT_EMPTY);
        } else if (table.isGameOver()) {
            return new GameState(state.player, Message.GAME_OVER);
        } else {
            Player nextPlayer = state.player == Player.PLAYER_ONE ? Player.PLAYER_TWO : Player.PLAYER_ONE;
            return new GameState(nextPlayer, Message.ENTER_COMMAND);
        }
    }

    public String drawTable() {
        return table.draw();
    }

}
