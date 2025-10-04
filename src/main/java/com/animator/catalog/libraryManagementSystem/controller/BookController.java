package com.animator.catalog.libraryManagementSystem.controller;

import com.animator.catalog.libraryManagementSystem.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookController {

    // We can use idBooMap only
    // No need to remove and add again and again, we can use isAvailable for that handling
    // ConcurrentMaps/List should be used for thread safety, race condition, concurrency
    // Synchronized method blocks can be used, but it blocks whole method with thread safe, so deadlocks occurs two thread wate same time

    private List<Book> bookList = new ArrayList<>();
    private List<Book> borrowedBookList = new ArrayList<>();
    private HashMap<Integer, Book> idBookMap = new HashMap<>();
    private HashMap<String, List<Book>> titleBookMap = new HashMap<>();
    private HashMap<String, List<Book>> authorBookMap = new HashMap<>();

    public void addBook(Book book){
        bookList.add(book);
        idBookMap.put(book.getId(), book);
        titleBookMap.computeIfAbsent(book.getTitle(), k-> new ArrayList<>()).add(book);
        authorBookMap.computeIfAbsent(book.getAuthor(), k-> new ArrayList<>()).add(book);
    }

    public void removeBook(Book book){
        bookList.remove(book);
        idBookMap.remove(book.getId());
        titleBookMap.get(book.getTitle()).remove(book);
        authorBookMap.get(book.getAuthor()).remove(book);
    }

    public void searchBookList() {
        for (Book book : bookList) {
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getUin());
        }
    }

    public void searchBookListByTitle(String title){
        System.out.println(title + ": ");
        for (Book book : titleBookMap.get(title)) {
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getUin());
        }
    }

    public void searchBookListByAuthor(String author){
        System.out.println(author + ": ");
        for (Book book : authorBookMap.get(author)) {
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getUin());
        }
    }

    public void borrowBook(Book book){
        book.setAvailable(false);
        removeBook(book);
        borrowedBookList.add(book);
    }

    public void returnBook(Book book){
        book.setAvailable(true);
        addBook(book);
        borrowedBookList.remove(book);
    }

    public void searchBorrowedBooks(){
        for (Book book : borrowedBookList) {
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getUin());
        }
    }
}
