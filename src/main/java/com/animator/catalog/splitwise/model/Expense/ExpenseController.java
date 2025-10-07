package com.animator.catalog.splitwise.model.Expense;

import com.animator.catalog.splitwise.model.BalanceSheetController;
import com.animator.catalog.splitwise.model.Expense.Split.Split;
import com.animator.catalog.splitwise.model.Expense.Split.SplitStrategy;
import com.animator.catalog.splitwise.model.User.User;

import java.util.List;

public class ExpenseController {

    private BalanceSheetController balanceSheetController;
    public ExpenseController(){
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(int expenseId, String description, double amount, User paidBy, SplitType splitType, List<Split> splitList){
        SplitStrategy splitStrategy = SplitFactory.getSplitStrategy(splitType);
        splitStrategy.validateSplit(splitList, amount);
        Expense expense = new Expense(expenseId, description, amount, paidBy, splitType, splitList);
        balanceSheetController.updateUserBalanceSheet(expense);
        return expense;

    }

}
