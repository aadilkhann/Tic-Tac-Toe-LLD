package org.ttt.Model;

public class Move {
    private final Player player;
    private final int row;
    private final int col;
    private final Symbol symbol;

    public Move(Player player, int row, int col, Symbol symbol) {
        this.player = player;
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
