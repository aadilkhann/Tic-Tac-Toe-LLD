package org.ttt.Model;

import java.util.Arrays;

public class Board {
    private final int size;
    private final Symbol[][] cells;

    public Board(int size) {
        this.cells = new  Symbol[size][size];
        this.size = size;

        for (int i = 0; i < size; i++) {
            Arrays.fill(cells[i], Symbol.EMPTY);
        }

    }

    public int getSize() {
        return size;
    }

    public boolean placeMove(int row, int col, Symbol symbol) {
        if (!isValidPosition(row, col)) {
            return false;
        }

        if (!isEmpty(row, col)) {
            return false;
        }

        cells[row][col] = symbol;
        return true;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < size  && col >= 0 && col < size;
    }

    public Symbol getSymbol(int x, int y) {
        return cells[x][y];
    }

    public boolean isEmpty(int x, int y) {
        return cells[x][y] == Symbol.EMPTY;
    }
}
