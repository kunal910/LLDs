package com.animator.catalog.splitwise.model.Expense;

import com.animator.catalog.splitwise.model.Expense.Split.EqualSplitStrategy;
import com.animator.catalog.splitwise.model.Expense.Split.PercentageSplitStrategy;
import com.animator.catalog.splitwise.model.Expense.Split.SplitStrategy;
import com.animator.catalog.splitwise.model.Expense.Split.UnequalSplitStrategy;

public class SplitFactory {
    public static SplitStrategy getSplitStrategy(SplitType splitType){
        switch (splitType){
            case EQUAL:
                return new EqualSplitStrategy();
            case UNEQUAL:
                return new UnequalSplitStrategy();
            case PERCENTAGE:
                return new PercentageSplitStrategy();
            default:
                throw new RuntimeException("Split Type not configured");
        }
    }
}
