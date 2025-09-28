package com.animator.catalog.calculator.model;

public class DivideOperationStrategy implements OperationStrategy{
    @Override
    public double executeOperation(double a, double b) {
        System.out.println("Divide the numbers");
        if(b==0){
            throw new ArithmeticException("Division not possible");
        }
        return a/b;
    }
}
