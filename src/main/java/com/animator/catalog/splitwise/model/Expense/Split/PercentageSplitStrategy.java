package com.animator.catalog.splitwise.model.Expense.Split;

import java.util.List;

public class PercentageSplitStrategy implements SplitStrategy{
    @Override
    public void validateSplit(List<Split> splitList, double amount) {
        if (splitList == null || splitList.isEmpty()) {
            throw new IllegalArgumentException("Split list cannot be empty.");
        }

        double totalPercent = 0.0;
        for (Split split : splitList) {
            totalPercent += split.getAmountOwe();  // here amountOwe represents percentage (e.g. 20 for 20%)
        }

        if (Math.abs(totalPercent - 100.0) > 0.01) {
            throw new IllegalArgumentException("Split percentages must sum up to 100.");
        }

        // Convert percentage to amount
        for (Split split : splitList) {
            double calculatedAmount = (amount * split.getAmountOwe()) / 100.0;
            split.setAmountOwe(Math.round(calculatedAmount * 100.0) / 100.0);
        }
    }
}
