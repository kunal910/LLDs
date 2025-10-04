package com.animator.catalog.libraryManagementSystem.model;

import com.animator.catalog.libraryManagementSystem.controller.BookController;

import java.util.ArrayList;
import java.util.List;

public class Library {
    BookController bookController;
    List<User> userList = new ArrayList<>();

    public Library(BookController bookController) {
        this.bookController = bookController;
    }

    public void addBook(Book book){
        bookController.addBook(book);
    }

    public void getAllBooks(){
        bookController.searchBookList();
    }

    public void searchBooksByAuthor(String  author){
        bookController.searchBookListByAuthor(author);
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void issueBook(User user, Book book){
        if(!book.isAvailable()){
            System.out.println("Book: " + book.getId() + "-" + book.getTitle() + " is not available");
            return;
        }
        user.addBook(book);
        bookController.borrowBook(book);
        System.out.println("Book: " + book.getId() + "-" + book.getTitle() + " borrowed by User: " + user.getId() + "-" + user.getName());
    }

    public void returnBook(User user, Book book){
        user.returnBook(book);
        bookController.returnBook(book);
        System.out.println("Book: " + book.getId() + "-" + book.getTitle() + " return by User: " + user.getId() + "-" + user.getName());
    }

    public void printAllUsers(){
        System.out.println("All Library members: ");
        for(User u: userList){
            System.out.println(u.getId() + "-" + u.getName());
        }
    }

    public void printUserTransactionHistory(User user){
        user.printTransactionHistory();
    }

    public void searchBorrowedBooks(){
        bookController.searchBorrowedBooks();
    }

}
