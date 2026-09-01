package org.ttt.Service;

import org.ttt.Model.Board;
import org.ttt.Model.Move;
import org.ttt.Model.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int playerIndex;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.players = new ArrayList<>(Arrays.asList(player1, player2));
    }

    public void makeMove(int x, int y) {
        Player player = players.get(playerIndex);
        if(board.isEmpty(x, y)){
            board.placeMove(x,y,player.getSymbol());
            System.out.println("Player moved!");
            checkWinner();
            switchPlayer();
        }
        else{
            System.out.println("Illegal move");
        }
    }

    public void checkWinner() {
//        algo to check winner

    }

    public void switchPlayer() {
        if (playerIndex ==0) playerIndex = 1;
        else playerIndex = 0;
    }
}
