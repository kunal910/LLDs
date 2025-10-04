package com.animator.catalog.libraryManagementSystem;

import com.animator.catalog.libraryManagementSystem.controller.BookController;
import com.animator.catalog.libraryManagementSystem.model.Book;
import com.animator.catalog.libraryManagementSystem.model.Library;
import com.animator.catalog.libraryManagementSystem.model.User;

public class LmsMain {
    public static void main(String[] args) {
        Library library = new Library(new BookController());

        Book book1 = new Book(1, "GOT", "Kunal", "119");
        Book book2 = new Book(2, "Vampire", "Shrey", "120");
        Book book3 = new Book(3, "GOT", "Kunal", "121");
        Book book4 = new Book(4, "Heist", "Shrey", "122");
        Book book5 = new Book(5, "CodeCpp", "Saini", "124");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        library.getAllBooks();
        System.out.println("-----------------------------");

        library.searchBooksByAuthor("Kunal");
        System.out.println("-----------------------------");

        library.searchBooksByAuthor("Shrey");
        System.out.println("-----------------------------");

        User user1 = new User(1, "User1", "u1@email");
        User user2 = new User(2, "User2", "u2@email");
        library.addUser(user1);
        library.addUser(user2);

        library.printAllUsers();
        System.out.println("-----------------------------");

        library.issueBook(user1, book1);
        library.issueBook(user1, book2);
        System.out.println("-----------------------------");

        library.printUserTransactionHistory(user1);
        System.out.println("-----------------------------");
        library.getAllBooks();
        System.out.println("-----------------------------");
        library.searchBorrowedBooks();
        System.out.println("-----------------------------");

        library.issueBook(user2, book1);
        System.out.println("-----------------------------");

        library.returnBook(user1, book1);
        System.out.println("-----------------------------");

        library.printUserTransactionHistory(user1);
        System.out.println("-----------------------------");

        library.issueBook(user2, book1);
        library.issueBook(user2, book4);
        library.issueBook(user2, book5);
        System.out.println("-----------------------------");

        library.printUserTransactionHistory(user2);
        System.out.println("-----------------------------");

        library.issueBook(user1, book4);


    }
}
