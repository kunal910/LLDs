package com.animator.catalog.ticTacToe;

import com.animator.catalog.ticTacToe.model.*;
import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TicTacToe {
    public Deque<Player> players;
    public Board game;
    TicTacToe(){
        initialize();
    }

    private void initialize(){
        players = new LinkedList<>();
        game = new Board(3);
        Player player1 = new Player("Boss1", new PlayingPieceX());
        Player player2 = new Player("Boss2", new PlayingPieceO());
        players.add(player1);
        players.add(player2);
    }

    public String startGame(){
        boolean isWinner = true;
        while(isWinner){
            Player curPlayer = players.removeFirst();
            game.showBoard();
            List<Pair<Integer, Integer>> emptyCells = game.getEmptyCells();
            if(emptyCells.isEmpty()){
                break;
            }
            System.out.print("Player:" + curPlayer.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int irow = Integer.parseInt(values[0]);
            int icol = Integer.parseInt(values[1]);
            if(!game.addPiece(irow, icol, curPlayer.playingPiece)){
                players.addFirst(curPlayer);
                System.out.println("Incorrect position, try valid move");
                continue;
            }
            players.addLast(curPlayer);
            boolean winner = isThereWinner(irow, icol, curPlayer.playingPiece);
            if(winner){
                return curPlayer.name;
            }
        }
        return "TIE";
    }

    private boolean isThereWinner(int irow, int icol, PlayingPiece playingPiece) {
        boolean isRoM = true;
        boolean isCoM = true;
        boolean isDiM = true;
        boolean isAdM = true;

        for(int i=0;i< game.size;i++){
            if(game.board[i][icol]==null || game.board[i][icol]!=playingPiece){
                isRoM = false;
                break;
            }
        }
        for(int j=0;j< game.size;j++){
            if(game.board[irow][j]==null || game.board[irow][j]!=playingPiece){
                isCoM = false;
                break;
            }
        }
        for(int i=0,j=0;i< game.size; i++,j++){
            if(game.board[i][j]==null || game.board[i][j]!=playingPiece){
                isDiM = false;
                break;
            }
        }
        for(int i=0,j= game.size-1;i< game.size; i++,j--){
            if(game.board[i][j]==null || game.board[i][j]!=playingPiece){
                isAdM = false;
                break;
            }
        }
        return isRoM || isCoM || isDiM || isAdM;
    }
}
