package com.animator.catalog.splitwise.model.Expense.Split;

import java.util.List;

public interface SplitStrategy {
    public void validateSplit(List<Split> splitList, double amount);
}
