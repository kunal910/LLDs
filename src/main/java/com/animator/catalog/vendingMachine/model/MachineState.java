package com.animator.catalog.vendingMachine.model;

public interface MachineState {
    void insertMoney(int money);
    void selectProduct(int id);
    void cancel();
}
