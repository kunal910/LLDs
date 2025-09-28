package com.animator.catalog.calculator.model;

public class AddOperationStrategy implements OperationStrategy{

    @Override
    public double executeOperation(double a, double b) {
        System.out.println("Add the numbers");
        return a+b;
    }
}
