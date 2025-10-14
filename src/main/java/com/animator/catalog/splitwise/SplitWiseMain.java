package com.animator.catalog.splitwise;

import com.animator.catalog.splitwise.model.BalanceSheetController;
import com.animator.catalog.splitwise.model.Expense.ExpenseController;
import com.animator.catalog.splitwise.model.Expense.Split.Split;
import com.animator.catalog.splitwise.model.Expense.SplitType;
import com.animator.catalog.splitwise.model.User.User;
import com.animator.catalog.splitwise.model.User.UserController;

import java.util.ArrayList;
import java.util.List;

public class SplitWiseMain {
    public static void main(String[] args) {

        ExpenseController expenseController = new ExpenseController();
        BalanceSheetController balanceSheetController = new BalanceSheetController();
        UserController userController = new UserController();

        User user1 = new User(1,"kunal","kunal.com","111");
        User user2 = new User(2,"shikha","shikha.com","222");
        User user3 = new User(3,"shrey","shrey.com","333");
        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);

        List<Split> splitList1  = new ArrayList<>();
        splitList1.add(new Split(0,user1));
        splitList1.add(new Split(0,user2));
        splitList1.add(new Split(0,user3));
        expenseController.createExpense(1, "Lunch", 300, user1, SplitType.EQUAL, splitList1);

        for(User user : userController.getAllUsers()){
            balanceSheetController.showUserBalance(user);
            System.out.println("-----------------------------------");
        }

        List<Split> splitList2  = new ArrayList<>();
        splitList2.add(new Split(20,user1));
        splitList2.add(new Split(50,user2));
        splitList2.add(new Split(30,user3));
        expenseController.createExpense(2, "Dinner", 500, user2, SplitType.PERCENTAGE, splitList2);

        for(User user : userController.getAllUsers()){
            balanceSheetController.showUserBalance(user);
            System.out.println("-----------------------------------");
        }

        List<Split> splitList3  = new ArrayList<>();
        splitList3.add(new Split(150,user1));
        splitList3.add(new Split(200,user2));
        splitList3.add(new Split(100,user3));
        expenseController.createExpense(3, "Trip", 450, user3, SplitType.UNEQUAL, splitList3);

        for(User user : userController.getAllUsers()){
            balanceSheetController.showUserBalance(user);
            System.out.println("-----------------------------------");
        }

    }
}
