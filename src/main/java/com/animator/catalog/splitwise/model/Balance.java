package com.animator.catalog.splitwise.model;

public class Balance {
    private Double amountOwe = 0.0;
    private Double amountGetBack = 0.0;

    public Double getAmountOwe() {
        return amountOwe;
    }

    public void addAmountOwe(Double amountOwe) {
        this.amountOwe += amountOwe;
    }

    public Double getAmountGetBack() {
        return amountGetBack;
    }

    public void addAmountGetBack(Double amountGetBack) {
        this.amountGetBack += amountGetBack;
    }

    public Double getNetAmount(){
        return amountGetBack - amountOwe;
    }
}
