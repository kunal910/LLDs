package com.animator.catalog.splitwise.model;

import com.animator.catalog.splitwise.model.User.User;

import java.util.HashMap;

public class BalanceSheet {
    private HashMap<User, Balance> userVsBalance;
    private Double totalAmountOwe;
    private Double totalAmountGetBack;

    public BalanceSheet(){
        this.userVsBalance = new HashMap<>();
        this.totalAmountOwe = 0.0;
        this.totalAmountGetBack = 0.0;
    }

    public void updateBalance(User otherUser, Double amount){
        Balance balance = userVsBalance.getOrDefault(otherUser, new Balance());
        if(amount>0){
            balance.addAmountGetBack(amount);
            totalAmountGetBack+=amount;
        }else{
            balance.addAmountOwe(-amount);
            totalAmountOwe-=amount;
        }
    }

    public Double getTotalAmountGetBack() {
        return totalAmountGetBack;
    }

    public Double getTotalAmountOwe() {
        return totalAmountOwe;
    }

    public HashMap<User, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public Double getNetAmount(){
        return totalAmountGetBack - totalAmountOwe;
    }
}
