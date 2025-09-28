package com.animator.catalog.calculator;

import com.animator.catalog.calculator.model.*;

public class CalculatorMain {
    public static void main(String[] args) {
        OperationStrategy add = new AddOperationStrategy();
        OperationStrategy sub = new SubtractOperationStrategy();
        OperationStrategy mul = new MultiplyOperationStrategy();
        OperationStrategy div = new DivideOperationStrategy();

        double val = sub.executeOperation(add.executeOperation(mul.executeOperation(div.executeOperation(6,2), 50), 5),15);
        System.out.println("Final result: " + val);
    }
}
