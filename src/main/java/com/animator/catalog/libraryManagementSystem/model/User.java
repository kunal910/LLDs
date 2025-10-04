package com.animator.catalog.libraryManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    String email;
    List<Transaction> transactionHistory = new ArrayList<>();

    public User(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for User: " + name + " -> ");
        for (Transaction t: transactionHistory){
            System.out.println(t.getUin() + "-" +  t.getIssueDate() + "-" + t.getReturnDate());
        }
    }

    public void addBook(Book book){
        Transaction transaction = new Transaction(book.uin, String.valueOf(System.currentTimeMillis()), null);
        this.transactionHistory.add(transaction);
    }

    public void returnBook(Book book){
        Transaction transaction = new Transaction(book.uin, null, String.valueOf(System.currentTimeMillis()));
        this.transactionHistory.add(transaction);
    }

}
