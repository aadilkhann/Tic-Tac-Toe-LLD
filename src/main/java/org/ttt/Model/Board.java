package org.ttt.Model;

import java.util.Arrays;

public class Board {
    private final int size;
    private final Symbol[][] cells;

    private int totalMoves;

    private final int[] rowCount;
    private final int[] colCount;
    private int diagonalCount;
    private int antiDiagonalCount;

    public Board(int size) {
        this.cells = new  Symbol[size][size];
        this.size = size;
        this.totalMoves = 0;
        this.rowCount = new int[size];
        this.colCount = new int[size];
        Arrays.fill(this.rowCount, 0);
        Arrays.fill(this.colCount, 0);

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
        totalMoves++;
        registerMove(row,col,symbol);
        return true;
    }

    private void registerMove(int row, int col, Symbol symbol) {
        if(symbol == Symbol.X) {
            rowCount[row]++;
            colCount[col]++;
            if (row==col){
                diagonalCount++;
            }
            if(row + col == size - 1){
                antiDiagonalCount++;
            }
        }
        else if(symbol == Symbol.O) {
            rowCount[row]--;
            colCount[col]--;

            if (row==col){
                diagonalCount--;
            }
            if(row + col == size - 1){
                antiDiagonalCount--;
            }
        }
    }

    public boolean hasWinner(int row, int col) {
        return Math.abs(rowCount[row]) == size
                || Math.abs(colCount[col]) == size
                || Math.abs(diagonalCount) == size
                || Math.abs(antiDiagonalCount) == size;
    }

    public boolean isFull() {
        return totalMoves == size * size;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < size  && col >= 0 && col < size;
    }

    public Symbol getSymbol(int row, int col) {
        return cells[row][col];
    }

    public boolean isEmpty(int row, int col) {
        return cells[row][col] == Symbol.EMPTY;
    }
}
