package com.animator.catalog.libraryManagementSystem.model;

public class Transaction {
    String uin;
    String issueDate;
    String returnDate;

    public Transaction(String uin, String issueDate, String returnDate){
        this.uin = uin;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public String getUin() {
        return uin;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
