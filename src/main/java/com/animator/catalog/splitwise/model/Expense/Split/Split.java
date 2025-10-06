package com.animator.catalog.splitwise.model.Expense.Split;

import com.animator.catalog.splitwise.model.User.User;

public class Split {
    private double amountOwe;
    private User user;

    public Split(double amountOwe, User user) {
        this.amountOwe = amountOwe;
        this.user = user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public User getUser() {
        return user;
    }
}
