package com.animator.catalog.ticTacToe.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;
    public Board(int size){
        this.size = size;
        this.board = new  PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col]=playingPiece;
        return true;
    }

    public void showBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print((board[i][j]==null ? "  " : board[i][j].pieceType.name() + " ") + "| ");
            }
            System.out.println();
        }
    }

    public List<Pair<Integer, Integer>> getEmptyCells() {
        List<Pair<Integer, Integer>> responseList = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    responseList.add(new Pair<>(i,j));
                }
            }
        }
        return responseList;
    }
}
