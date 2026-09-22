package org.ttt.Service;

import org.ttt.Model.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private int playerIndex;
    private GameStatus status;
    private Player winner;

    public Game(int size, Player player1, Player player2) {
        this.board = new Board(size);
        this.players = new ArrayList<>(Arrays.asList(player1, player2));
        this.status = GameStatus.IN_PROGRESS;
        this.winner = null;
    }

    public void makeMove(int row, int col) {
        if (status != GameStatus.IN_PROGRESS) return;

        Player player = players.get(playerIndex);
        boolean isPlaced=board.placeMove(row,col,player.getSymbol());
        if (!isPlaced){
            System.out.println("Illegal move! cannot place");
            return;
        }

        if (board.hasWinner(row, col)) {
            status = GameStatus.WON;
            winner = player;
            return;
        }

        if(board.isFull()){
            status = GameStatus.DRAW;
            return;
        }
        switchPlayer();
    }

    public void switchPlayer() {
        if (playerIndex ==0) playerIndex = 1;
        else playerIndex = 0;
    }
}
