package com.animator.catalog.libraryManagementSystem.model;

public class Book {
    int id;
    String title;
    String author;
    String uin;
    boolean isAvailable = true;

    public Book(int id, String title, String author, String uin){
        this.id = id;
        this.title = title;
        this.author = author;
        this.uin = uin;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUin() {
        return uin;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
