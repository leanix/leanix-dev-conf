package net.leanix.dev;

public abstract class BasePlayer implements Player {
    final String name;
    final CellState symbol;

    public BasePlayer(String name, CellState symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public abstract void move(Board board) ;

    @Override
    public CellState getCellState() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }
}
