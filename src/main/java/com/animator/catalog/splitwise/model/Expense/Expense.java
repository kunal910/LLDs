package com.animator.catalog.splitwise.model.Expense;

import com.animator.catalog.splitwise.model.Expense.Split.Split;
import com.animator.catalog.splitwise.model.User.User;

import java.util.List;

public class Expense {
    private int id;
    private String description;
    private double amount;
    private User paidBy;
    private SplitType splitType;
    private List<Split> splitList;


    public Expense(int id, String description, double amount, User paidBy, SplitType splitType, List<Split> splitList) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splitList = splitList;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

}
