package com.animator.catalog.splitwise.model.Expense.Split;

import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public void validateSplit(List<Split> splitList, double amount) {
        if (splitList == null || splitList.isEmpty()) {
            throw new IllegalArgumentException("Split list cannot be empty.");
        }

        double equalShare = Math.round((amount / splitList.size()) * 100.0) / 100.0;

        for (Split split : splitList) {
            split.setAmountOwe(equalShare);
        }

        double total = equalShare * splitList.size();

        if (Math.abs(total - amount) > 0.01) {
            throw new IllegalArgumentException("Split amounts do not sum up to total amount.");
        }
    }
}
