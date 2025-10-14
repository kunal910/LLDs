package com.animator.catalog.splitwise.model.Expense.Split;

import java.util.List;

public class UnequalSplitStrategy implements SplitStrategy{
    @Override
    public void validateSplit(List<Split> splitList, double amount) {
        if (splitList == null || splitList.isEmpty()) {
            throw new IllegalArgumentException("Split list cannot be empty.");
        }

        double total = 0.0;
        for (Split split : splitList) {
            total += split.getAmountOwe();
        }

        if (Math.abs(total - amount) > 0.01) {
            throw new IllegalArgumentException(
                    "Sum of individual amounts (" + total + ") does not match total expense amount (" + amount + ")."
            );
        }
    }
}
