package com.animator.catalog.ticTacToe.model;

public class Player {
    public String name;
    public PlayingPiece playingPiece;
    public Player(String name, PlayingPiece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }
    private void setName(String name){
        this.name = name;
    }
    private void setPlayingPiece(PlayingPiece playingPiece){
        this.playingPiece = playingPiece;
    }
    public String getName(){
        return this.name;
    }
    public PlayingPiece getPlayingPiece(){
        return this.playingPiece;
    }
}
