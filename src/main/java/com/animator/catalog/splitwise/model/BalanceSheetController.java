package com.animator.catalog.splitwise.model;

import com.animator.catalog.splitwise.model.Expense.Expense;
import com.animator.catalog.splitwise.model.Expense.Split.Split;
import com.animator.catalog.splitwise.model.User.User;

import java.util.Map;

public class BalanceSheetController {

    public void updateUserBalanceSheet(Expense expense){
        BalanceSheet balanceSheetPaidBy = expense.getPaidBy().getBalanceSheet();
        for (Split split: expense.getSplitList()){
            if (split.getUser() == expense.getPaidBy()){
                continue;
            }
            BalanceSheet balanceSheetOweBy = split.getUser().getBalanceSheet();

            balanceSheetPaidBy.updateBalance(split.getUser(), split.getAmountOwe());
            balanceSheetOweBy.updateBalance(expense.getPaidBy(), -split.getAmountOwe());
        }
    }

    public void showUserBalance(User user){
        System.out.println("Balance sheet for " + user.getName() + ":");
        for (Map.Entry<User, Balance> entry: user.getBalanceSheet().getUserVsBalance().entrySet()){
            User other = entry.getKey();
            Double netAmount = entry.getValue().getNetAmount();
            if (netAmount > 0){
                System.out.println(other.getName() + " owes: " + netAmount);
            }else{
                System.out.println(other.getName() + " gets back: " + (-netAmount));
            }
        }
        System.out.println("Total Owe: " + user.getBalanceSheet().getTotalAmountOwe());
        System.out.println("Total GetBack: " + user.getBalanceSheet().getTotalAmountGetBack());
        System.out.println("Net Balance: " + user.getBalanceSheet().getNetAmount());
    }

}
