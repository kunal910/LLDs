package com.animator.catalog.calculator.model;

public class SubtractOperationStrategy implements OperationStrategy{
    @Override
    public double executeOperation(double a, double b) {
        System.out.println("Subtract the numbers");
        return a-b;
    }
}
