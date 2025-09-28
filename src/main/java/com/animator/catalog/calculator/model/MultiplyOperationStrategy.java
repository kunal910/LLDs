package com.animator.catalog.calculator.model;

public class MultiplyOperationStrategy implements OperationStrategy{
    @Override
    public double executeOperation(double a, double b) {
        System.out.println("Multiply the numbers");
        return a*b;
    }
}
